<#-- ATTENZIONE!!!! L'IMPLEMENTAZIONE DEL SEGUENTE FTL DEVE ESSERE COMPLETATA-->


<#if !pojo.getDeclarationName().endsWith("Id")>
	package ${servicePackage}.service.impl;
	
	// Generated ${date}
	
	<#assign classbody>
	
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
		
		import java.util.Optional;

		import org.apache.commons.lang3.NotImplementedException;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.beans.factory.config.ConfigurableBeanFactory;
		import org.springframework.context.annotation.Scope;
		import org.springframework.stereotype.Service;
		import org.springframework.transaction.annotation.Propagation;
		import org.springframework.transaction.annotation.Transactional;
		
		import ${entityPackage}.${declarationName};
		import ${DAOPackage}.${declarationName}DAO;
		import ${DTOPackage}.${declarationName}DTO;
		import ${servicePackage}.exception.BusinessServiceException;
		import ${servicePackage}.mapper.${declarationName}Mapper;
		import ${servicePackage}.service.${declarationName}Service;
		import ${servicePackage}.service.impl.AbstractService;
		
		<#assign typeId = pojo.getJavaTypeName(clazz.identifierProperty, jdk5)>
		
		<#if typeId!="Long" && typeId!="String">
		 	import ${DTOPackage}.${declarationName}IdDTO;
		 	import ${entityPackage}.${declarationName}Id;
			import ${servicePackage}.mapper.${declarationName}IdMapper;
		</#if>		

		@Service("${declarationName?uncap_first}Service")
		@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
		public class ${declarationName}ServiceImpl extends AbstractService implements ${declarationName}Service {
			private Logger logger = LoggerFactory.getLogger(getClass());
			
			@Autowired
			private ${declarationName}DAO ${declarationName?uncap_first}DAO;
			@Autowired
			private ${declarationName}Mapper ${declarationName?uncap_first}Mapper;

			<#if typeId!="Long" && typeId!="String">
				@Autowired
				private ${declarationName}IdMapper ${declarationName?uncap_first}IdMapper;
			</#if>

			@Override
			@Transactional(propagation = Propagation.REQUIRED)
			public ${declarationName}DTO save(${declarationName}DTO dto) throws BusinessServiceException {
				try {
				<#-- 
					${declarationName} entity = new ${declarationName}();
		
					if (dto.getId() != null) {
						<#if typeId=="Long" || typeId=="String">
							logger.info("Aggiornamento del record con id {0}", dto.getId());
			
							Optional<${declarationName}> optionalEntity = bpTipoOggettoDAO.findById(dto.getId());

						<#else>
							${declarationName}Id id = ${declarationName?uncap_first}IdMapper.toEntity(dto.getId());

							logger.info("Aggiornamento del record con id {0}", id.toString());

							//Recupero il record da modificare dal DB
							Optional<${declarationName}> optionalEntity = ${declarationName?uncap_first}DAO.findById(id);
						</#if>
						
						if (optionalEntity.isPresent()) {
							entity = optionalEntity.get();
						}
					}
				-->
					//Copio i dati contenuti nel DTO nell'entità
					${declarationName} entity = ${declarationName?uncap_first}Mapper.toEntity(dto);
		
					//Salvo i dati
					entity = ${declarationName?uncap_first}DAO.save(entity);
		
					<#if typeId=="Long" || typeId=="String">
						dto.setId(entity.getId());
					<#else>
						dto.setId(${declarationName?uncap_first}IdMapper.toDTO(entity.getId()));
					</#if>
				
					return dto;
				} catch (Exception e) {
					throw new BusinessServiceException(e);
				}
			}
	
			@Override
			@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
			<#if typeId=="Long" || typeId=="String">
				public Optional<${declarationName}DTO> findById(${typeId} id) throws BusinessServiceException {
					Optional<${declarationName}DTO> dto = Optional.empty();

					if (id!=null){
						Optional<${declarationName}> entity = ${declarationName?uncap_first}DAO.findById(id);
			<#else>
				public Optional<${declarationName}DTO> findById(${declarationName}IdDTO id) throws BusinessServiceException {
					Optional<${declarationName}DTO> dto = Optional.empty();

					if (id!=null){
						${declarationName}Id entityId = ${declarationName?uncap_first}IdMapper.toEntity(id);
	
						Optional<${declarationName}> entity = ${declarationName?uncap_first}DAO.findById(entityId);
			</#if>
					
						if (entity.isPresent()){
							dto = Optional.of(${declarationName?uncap_first}Mapper.toDTO(entity.get()));
						}
					}else{
						logger.warn("La chiave passata è null");
					}

					return dto;
				}		
			
			@Override
			@Transactional(propagation = Propagation.REQUIRED)
			<#if typeId=="Long" || typeId=="String">
				public void deleteById(${typeId} id) throws BusinessServiceException{
			<#else>
				public void deleteById(${declarationName}IdDTO id) throws BusinessServiceException{
			</#if>
					throw new NotImplementedException("Funzione non ancora implementata");
				}
			
		}
	</#assign>
	
	${classbody}
</#if>