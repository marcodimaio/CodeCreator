package it.capgemini.archetype.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	// L'asterisco prima del package fa il match con qualunque tipo restituito
	// dal metodo
	// i .. fa il match con tutte le classi all'interno del package e dei sotto
	// package
	// il primo asterisco dopo il package fa il match con qualunque classe
	// il secondo asterisco dopo package fa il match con qualunque metodo
	// (..) fa il match con tutti i parametri del metodo
	@Pointcut("execution(* it.capgemini.archetype.srv.service..*.*(..))")
	private void serviceMethods() {
	}

	@Pointcut("execution(* it.capgemini.archetype.web.controller..*.*(..))")
	private void controllerMethods() {
	}

	@Before("serviceMethods() || controllerMethods()")
	public void logBefore(JoinPoint joinPoint) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(this.getLogMessage(joinPoint, "Start "));
		}
	}
	
	@After("serviceMethods() || controllerMethods()")
	public void logAfter(JoinPoint joinPoint) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(this.getLogMessage(joinPoint, "End "));
		}
	}

	private String getLogMessage(JoinPoint joinPoint, String prefix) {
		StringBuilder sb = new StringBuilder();

		sb.append(prefix);
		sb.append(joinPoint.getTarget().getClass().getSimpleName());
		sb.append(".");
		sb.append(joinPoint.getSignature().getName());

		// Aggiungo gli argomenti del metodo
		sb.append(Arrays.toString(joinPoint.getArgs()));

		sb.append(" method");

		return sb.toString();
	}
}
