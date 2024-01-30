<#if !pojo.getDeclarationName().endsWith("Id")>
	package ${DAOPackage};
	
	// Generated ${date}
	
	<#assign classbody>
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
	
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
	
		import ${DAOPackage}.DAO;
		import ${entityPackage}.${declarationName};
		
		import java.util.List;
		import java.util.Optional;
		
		import org.springframework.domain.Page;
		import org.springframework.domain.Pageable;	
		import org.springframework.domain.Sort;
	
		<#assign typeId = pojo.getJavaTypeName(clazz.identifierProperty, jdk5)>
	
		<#if typeId=="Long">
			import java.lang.Long;
		<#elseif typeId=="String">
			import java.lang.String;
		<#else>
		 	import ${entityPackage}.${declarationName}Id;
		</#if>
		
		public interface ${declarationName}DAO extends DAO {
		
			public List<${declarationName}> findAll();
		
			public List<${declarationName}> findAll(Sort sort);
		
			public List<${declarationName}> findAllById(Iterable<${typeId}> ids);
		
			public void flush();
		
			public ${declarationName} saveAndFlush(${declarationName} entity);
		
			public ${declarationName} getOne(${typeId} id);
				
			public Page<${declarationName}> findAll(Pageable pageable);
			
			public ${declarationName} save(${declarationName} entity);
			
			public Optional<${declarationName}> findById(${typeId} id);
			
			public boolean existsById(${typeId} id);
			
			public long count();
			
			public void deleteById(${typeId} id);
			
			public void delete(${declarationName} entity);
			
			public List<${declarationName}> findAll(${declarationName} entity);
		
			public Page<${declarationName}> findAll(${declarationName} entity, Pageable pageable);
		
			public List<${declarationName}> findAll(${declarationName} entity, Sort sort);			
		}
		
	</#assign>
	
	${classbody}

</#if>

