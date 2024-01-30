package it.capgemini.archetype.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import it.capgemini.archetype.dto.AbstractDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire la pagina di dettaglio senza però avere la
 * parte salvataggio e cancellazione
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface DetailController<DTOType extends AbstractDTO> extends BaseController {
	public void managementRedirect(ModelMap model, BindingResult bindingResult);
	
	/** Gestisce la richiesta GET relativa al path "/detail/{id}" */
	public String detail(Long id, ModelMap model, HttpServletRequest request) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/{id}" */
	public String cancelDetail(Long id, ModelMap model, HttpServletRequest request);

}
