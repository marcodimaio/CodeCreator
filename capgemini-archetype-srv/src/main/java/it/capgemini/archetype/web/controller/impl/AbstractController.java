package it.capgemini.archetype.web.controller.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.capgemini.archetype.web.controller.BaseController;

@Controller
@SessionAttributes("abstractController")
public abstract class AbstractController implements BaseController {

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
}
