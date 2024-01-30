package it.capgemini.archetype.srv.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import it.capgemini.archetype.dto.PageDTO;
import it.capgemini.archetype.srv.mapper.Mapper;

public abstract class AbstractMapper<E, D> implements Mapper<E, D> {
	@Autowired
	protected ModelMapper modelMapper;
	
	public abstract D toDTO(E entity);

	public abstract E toEntity(D dto);

	public List<D> toDTOS(List<E> entities) {
		if (CollectionUtils.isEmpty(entities))
			return new ArrayList<D>();

		List<D> dtos = new ArrayList<D>();

		for (E entity : entities) {
			D dto = toDTO(entity);

			dtos.add(dto);
		}

		return dtos;
	}
	
	public List<E> toEntities(List<D> dtos) {
		if (CollectionUtils.isEmpty(dtos))
			return null;

		List<E> entities = new ArrayList<E>();

		for (D dto : dtos) {
			E entity = toEntity(dto);

			entities.add(entity);
		}

		return entities;
	}	

	public PageDTO<D> toPageDTO(Page<E> page) {

		List<D> result = new ArrayList<D>();
		PageDTO<D> dto = new PageDTO<D>();

		List<E> pageList = page.getContent();

		if (pageList != null && !pageList.isEmpty()) {
			for (E entity : pageList) {
				D bean = toDTO(entity);

				result.add(bean);
			}
		}

		dto.setPageList(result);
		dto.setTotalElements(page.getTotalElements());

		return dto;
	}
}
