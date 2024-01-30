package it.capgemini.archetype.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.capgemini.archetype.dto.AbstractDTO;

/**
 * Interfaccia che va implementata nel caso di Controller che devono gestire le
 * operazioni di CRUD
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface CrudController<DTOType extends AbstractDTO> extends InsertController<DTOType> {
	/** Gestisce la richiesta POST relativa al path "/create" */
	public String create(ModelMap model, Principal principal, RedirectAttributes redirectAttributes, HttpServletRequest request)
			throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/insert" */
	public String insert(DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/insert" */
	public String cancelInsert(ModelMap model, HttpServletRequest request);
	
	/** Gestisce la richiesta GET relativa al path "/modify/{id}" */
	public String modify(Long id, ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/modify/{id}" */
	public String save(DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/modify/{id}" */
	public String cancelModify(Long id, ModelMap model, HttpServletRequest request);
	
	public void managementRedirect(ModelMap model, BindingResult bindingResult);
	
	/** Gestisce la richiesta GET relativa al path "/detail/{id}" */
	public String detail(Long id, ModelMap model, HttpServletRequest request) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/{id}" */
	public String cancelDetail(Long id, ModelMap model, HttpServletRequest request);
	
	/** Gestisce la richeista GET relativa al path "/delete/{id}" */
	public String delete(Long id, ModelMap model, Principal principal, HttpServletRequest request) throws Exception;

	/** Gestisce la richeista POST relativa al path "/detail/delete/{id}" */
	public String delete(Long id, DTOType dto, ModelMap model, BindingResult bindingResult, Principal principal,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception;

	/** Gestisce la richiesta POST relativa al path "/detail/delete/{id}" */
	public String cancelDelete(Long id, ModelMap model, HttpServletRequest request);
}
