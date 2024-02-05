<#if !pojo.getDeclarationName().endsWith("Id")>
	package ${repositoryPackage};
	
	// Generated ${date}
	
	<#assign classbody>
		<#-- Nome dell'entità -->
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
	
		import org.springframework.data.jpa.repository.JpaRepository;
		import org.springframework.data.querydsl.QuerydslPredicateExecutor;
		import org.springframework.stereotype.Repository;	
		import ${entityPackage}.${declarationName};
		
		<#assign typeId = pojo.getJavaTypeName(clazz.identifierProperty, jdk5)>
	
		<#if typeId=="Long">
			import java.lang.Long;
		<#elseif typeId=="String">
			import java.lang.String;
		<#else>
			import ${entityPackage}.${declarationName}Id;
		</#if>	
		
		@Repository			
		public interface ${declarationName}Repository extends JpaRepository<${declarationName}, ${typeId}>, QuerydslPredicateExecutor<${declarationName}> {
		
		}
		
	</#assign>

	${classbody}

</#if>

