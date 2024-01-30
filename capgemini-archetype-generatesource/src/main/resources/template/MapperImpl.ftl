<#-- <#if !pojo.getDeclarationName().endsWith("Id")> -->
	package ${mapperPackage}.impl;
	
	// Generated ${date}
	
	<#assign classbody>
	
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
		
		
		import org.springframework.beans.factory.config.ConfigurableBeanFactory;
		import org.springframework.context.annotation.Scope;
		import org.springframework.stereotype.Service;
		
		import ${entityPackage}.${declarationName};
		import ${DTOPackage}.${declarationName}DTO;
		import ${mapperPackage}.${declarationName}Mapper;
	
		@Service("${declarationName?uncap_first}Mapper")
		@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
		public class ${declarationName}MapperImpl extends AbstractMapper<${declarationName}, ${declarationName}DTO> implements ${declarationName}Mapper {
			@Override
			public ${declarationName}DTO toDTO(${declarationName} entity) {
				if(entity == null) {
					return null;
				}
				
				return modelMapper.map(entity, ${declarationName}DTO.class);
			}
		
			@Override
			public ${declarationName} toEntity(${declarationName}DTO dto) {
				if(dto == null) {
					return null;
				}

				return modelMapper.map(dto, ${declarationName}.class);
			}
		
		}
	
	</#assign>
	
	${classbody}
<#-- </#if> -->