package it.capgemini.archetype.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.capgemini.archetype.dto.AbstractDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire le
 * operazioni di creazione e inserimento
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface InsertController<DTOType extends AbstractDTO> extends BaseController {
	/** Gestisce la richiesta POST relativa al path "/create" */
	public String create(ModelMap model, Principal principal, RedirectAttributes redirectAttributes, HttpServletRequest request)
			throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/insert" */
	public String insert(DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/insert" */
	public String cancelInsert(ModelMap model, HttpServletRequest request);

}
