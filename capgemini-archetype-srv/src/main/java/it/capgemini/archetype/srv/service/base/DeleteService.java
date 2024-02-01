package it.capgemini.archetype.srv.service.base;

import java.io.Serializable;

import it.capgemini.archetype.dto.AbstractDTO;
import it.capgemini.archetype.srv.exception.BusinessServiceException;

/**
 * Interfaccia che va implementata nel caso di Business che realizzano un la cancellazione
 * 
 * @param <ID> Classe che mappa la chiave primaria dell'entità ed estende {@link AbstractDTO}
 */
public interface DeleteService<ID extends Serializable> extends Service {
	public void deleteById(ID id) throws BusinessServiceException;
}
