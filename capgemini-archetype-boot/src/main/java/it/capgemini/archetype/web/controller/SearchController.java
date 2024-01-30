package it.capgemini.archetype.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import it.capgemini.archetype.dto.search.AbstractSearchDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire le operazioni di search
 * 
 * @param <SearchDTOType>
 *            dto che estende la classe {@link AbstractSearchDTO}
 */
public interface SearchController<SearchDTOType extends AbstractSearchDTO>
		extends BaseController {
	/** Gestisce la richiesta GET relativa al path "/search" */
	public String search(final String page, String sort, String dir, SearchDTOType searchDTO, ModelMap model,
			BindingResult bindingResult, Principal principal, HttpServletRequest request) throws Exception;
}
