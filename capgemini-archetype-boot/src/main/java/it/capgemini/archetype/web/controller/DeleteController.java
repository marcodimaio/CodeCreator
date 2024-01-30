package it.capgemini.archetype.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.capgemini.archetype.dto.AbstractDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire le
 * operazioni di cancellazione
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface DeleteController<DTOType extends AbstractDTO> extends BaseController {
	/** Gestisce la richeista GET relativa al path "/delete/{id}" */
	public String delete(Long id, ModelMap model, Principal principal, HttpServletRequest request) throws Exception;

	/** Gestisce la richeista POST relativa al path "/detail/delete/{id}" */
	public String delete(Long id, DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/delete/{id}" */
	public String cancelDelete(Long id, ModelMap model, HttpServletRequest request);

}
