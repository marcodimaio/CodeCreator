package it.capgemini.archetype.dto;

import java.util.List;

public class PageDTO<T> {
	private List<T> pages;
	private Long totalElements;

	public List<T> getPageList() {
		return pages;
	}

	public void setPageList(List<T> pageList) {
		this.pages = pageList;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public int getTotalElementsAsInt() {
		return totalElements.intValue();
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

}
