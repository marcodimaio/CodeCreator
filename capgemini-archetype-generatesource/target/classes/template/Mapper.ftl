<#-- <#if !pojo.getDeclarationName().endsWith("Id")> -->
	package ${mapperPackage};
	
	// Generated ${date}
	
	<#assign classbody>
		<#-- Nome dell'entità -->
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
	
		import ${entityPackage}.${declarationName};
		import ${DTOPackage}.${declarationName}DTO;
		
		public interface ${declarationName}Mapper extends Mapper<${declarationName}, ${declarationName}DTO> {
		
		}
		
	</#assign>

	${classbody}

<#-- </#if> -->

