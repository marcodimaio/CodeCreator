package it.capgemini.archetype.srv.service.base;

import java.io.Serializable;
import java.util.Optional;

import it.capgemini.archetype.dto.AbstractDTO;
import it.capgemini.archetype.srv.exception.BusinessServiceException;

/**
 * Interfaccia che va implementata nel caso di Business che realizzano solo la
 * ricerca
 * 
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 * @param <ID>
 *            Classe che mappa la chiave primaria dell'entità ed estende
 *            {@link AbstractDTO}
 */
public interface FindService<DTOType extends AbstractDTO, ID extends Serializable> extends Service {
	public Optional<DTOType> findById(ID id) throws BusinessServiceException;
}
