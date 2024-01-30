<#if !pojo.getDeclarationName().endsWith("Id")>
	package ${servicePackage};
	
	// Generated ${date}
	
	<#assign classbody>
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
	
		import ${DTOPackage}.${declarationName}DTO;
		import ${servicePackage}.base.CrudService;
		
		<#assign typeId = pojo.getJavaTypeName(clazz.identifierProperty, jdk5)>
		
		<#if typeId=="Long" || typeId=="String">
			public interface ${declarationName}Service extends CrudService<${declarationName}DTO, ${typeId}> {
		<#else>
		 	import ${DTOPackage}.${declarationName}IdDTO;

			public interface ${declarationName}Service extends CrudService<${declarationName}DTO, ${declarationName}IdDTO> {
		</#if>
		}
	
	</#assign>
	
	${classbody}
</#if>