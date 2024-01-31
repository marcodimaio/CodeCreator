package it.capgemini.archetype.srv.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import it.capgemini.archetype.srv.service.base.Service;

public abstract class AbstractService implements Service {
	protected Pageable constructPageSpecification(int pageIndex, int pageSize, String sortField,
			Boolean sortDirectionAsc) {
		Pageable pageSpecification = PageRequest.of(pageIndex, pageSize, sortBy(sortField, sortDirectionAsc));

		return pageSpecification;
	}

	protected Pageable constructPageSpecification(int pageIndex, int pageSize, boolean sortDirectionAsc,
			String... columns) {
		Direction direction = null;

		if (sortDirectionAsc) {
			direction = Direction.ASC;
		} else {
			direction = Direction.DESC;
		}

		Pageable pageable = PageRequest.of(pageIndex, pageSize, direction, columns);

		return pageable;
	}

	protected Pageable constructPageSpecification(int pageIndex, int pageSize, String sortField) {
		return constructPageSpecification(pageIndex, pageSize, sortField, true);
	}

	protected Pageable constructPageSpecification(int pageIndex, int pageSize) {
		return constructPageSpecification(pageIndex, pageSize, null, true);
	}

	private Sort sortBy(String sortField, Boolean sortDirectionAsc) {
		if (sortField == null || sortDirectionAsc == null) {
			return null;
		}

		return sortDirectionAsc ? Sort.by(Sort.Direction.ASC, sortField) : Sort.by(Sort.Direction.DESC, sortField);
	}

}
