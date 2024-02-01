package it.capgemini.archetype.web.controller.impl;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.capgemini.archetype.web.controller.BaseController;
import it.capgemini.archetype.web.enumerator.ViewState;

@Controller
@SessionAttributes("abstractController")
public abstract class AbstractController implements BaseController {
	protected final String MODEL_VIEWSTATE = "viewState";

	@Autowired
	private ResourceBundleMessageSource messageSource;

	protected ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	protected void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	protected boolean isSortDirectionAsc(String direction) {
		boolean sortDirectionAsc = true;

		if (StringUtils.isNotEmpty(direction)) {
			if ("desc".equals(direction)) {
				sortDirectionAsc = false;
			}
		}

		return sortDirectionAsc;
	}

	protected String getSortColumn(String sort, String defaultColumn) {
		if (sort == null) {
			return defaultColumn;
		} else {
			return sort;
		}
	}

	protected int getPageIndex(String page) {
		int pageIndex = 1;

		if (page != null && !page.isEmpty()) {
			pageIndex = Integer.parseInt(page);
		}

		return pageIndex;
	}

	protected void setViewState(ModelMap model, ViewState viewState) {
		model.addAttribute(MODEL_VIEWSTATE, viewState);
	}

	protected void setViewState(RedirectAttributes redirectAttributes, ViewState viewState) {
		redirectAttributes.addFlashAttribute(MODEL_VIEWSTATE, viewState);
	}

	protected String getMessage(String keyMessage, Object[] parameterMessages) {
		return this.getMessageSource().getMessage(keyMessage, parameterMessages, Locale.getDefault());
	}
}
