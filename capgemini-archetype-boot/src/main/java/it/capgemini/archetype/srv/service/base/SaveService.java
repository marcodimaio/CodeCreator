package it.capgemini.archetype.srv.service.base;

import it.capgemini.archetype.dto.AbstractDTO;
import it.capgemini.archetype.srv.exception.BusinessServiceException;

/**
 * Interfaccia che va implementata nel caso di Business che realizzano il
 * salvataggio
 * 
 * @param <DTOType> dto che estende la classe {@link AbstractDTO}
 */
public interface SaveService<DTOType extends AbstractDTO> extends Service {
	public DTOType save(DTOType dto) throws BusinessServiceException;
}
