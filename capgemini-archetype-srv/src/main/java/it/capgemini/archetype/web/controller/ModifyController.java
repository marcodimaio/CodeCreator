package it.capgemini.archetype.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.capgemini.archetype.dto.AbstractDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire le operazioni di modifica e salvataggio
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface ModifyController<DTOType extends AbstractDTO> extends BaseController {
	/** Gestisce la richiesta GET relativa al path "/modify/{id}" */
	public String modify(Long id, ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/modify/{id}" */
	public String save(DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/modify/{id}" */
	public String cancelModify(Long id, ModelMap model, HttpServletRequest request);

}
