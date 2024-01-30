package it.capgemini.archetype.srv.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

import it.capgemini.archetype.dto.PageDTO;

public interface Mapper<E, D> {
	public D toDTO(E entity);
	
	public E toEntity(D dto);
	
	public List<D> toDTOS(List<E> entities);
	
	public PageDTO<D> toPageDTO(Page<E> page);
	
}
