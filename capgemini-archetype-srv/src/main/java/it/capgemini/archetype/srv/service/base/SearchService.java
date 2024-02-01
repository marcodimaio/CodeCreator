package it.capgemini.archetype.srv.service.base;

import it.capgemini.archetype.dto.AbstractDTO;
import it.capgemini.archetype.dto.PageDTO;
import it.capgemini.archetype.dto.search.AbstractSearchDTO;
import it.capgemini.archetype.srv.exception.BusinessServiceException;

/**
 * Interfaccia che va implementata nel caso di Business che realizzano la ricerca parametrica
 * 
 * @param <SearchDTOType>
 *            dto che estende la classe {@link AbstractSearchDTO}
 * @param <DTOType>
 *            dto che estende la classe {@link AbstractDTO}
 */
public interface SearchService<SearchDTOType extends AbstractSearchDTO, DTOType extends AbstractDTO> extends Service {
	public PageDTO<DTOType> search(SearchDTOType searchDTO, int pageIndex, int pageSize, String sortColumn,
			boolean sortDirectionAsc) throws BusinessServiceException;
}
