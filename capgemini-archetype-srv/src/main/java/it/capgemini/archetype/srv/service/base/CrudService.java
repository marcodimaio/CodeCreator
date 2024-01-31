package it.capgemini.archetype.srv.service.base;

import java.io.Serializable;
import java.util.Optional;

import it.capgemini.archetype.dto.AbstractDTO;
import it.capgemini.archetype.srv.exception.BusinessServiceException;

/**
 * Interfaccia che va implementata nel caso di Business che realizzano un CRUD
 * completo
 * 
 * @param <DTOType>
 *            dto che implementa la classe {@link AbstractDTO}
 * @param <ID>
 *            Classe che mappa la chiave primaria dell'entità ed estende
 *            {@link AbstractDTO}
 */
public interface CrudService<DTOType extends AbstractDTO, ID extends Serializable> extends Service {
	public Optional<DTOType> findById(ID id) throws BusinessServiceException;

	public DTOType save(DTOType dto) throws BusinessServiceException;

	public void deleteById(ID id) throws BusinessServiceException;
}
