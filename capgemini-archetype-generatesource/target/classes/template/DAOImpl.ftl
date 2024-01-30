<#if !pojo.getDeclarationName().endsWith("Id")>
	package ${DAOPackage}.impl;
	
	// Generated ${date}
	
	<#assign classbody>
		<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
	
		<#-- Leggo il package di appartenenza dell'entità ed elimino la stringa 
		package e il punto e virgola finale -->
		<#assign entityPackage = pojo.getPackageDeclaration()?replace("package", "")?replace(";", "")>
	
		import ${DAOPackage}.impl.AbstractDAO;
		import ${entityPackage}.${declarationName};
		import ${DAOPackage}.${declarationName}DAO;
		import ${repositoryPackage}.${declarationName}Repository;
		
		import org.springframework.beans.factory.annotation.Autowired;
		import java.util.List;
		import java.util.Optional;
		
		import org.springframework.domain.Example;
		import org.springframework.domain.Page;
		import org.springframework.domain.Pageable;
		import org.springframework.domain.Sort;
		import org.springframework.stereotype.Service;
		
		<#assign typeId = pojo.getJavaTypeName(clazz.identifierProperty, jdk5)>
		<#assign entityName = declarationName.substring(0,1).toLowerCase() + declarationName.substring(1)>
	
		<#if typeId=="Long">
			import java.lang.Long;
		<#elseif typeId=="String">
			import java.lang.String;
		<#else>
		 	import ${entityPackage}.${declarationName}Id;
		</#if>
		
		@Service("${entityName}DAO")
		public class ${declarationName}DAOImpl extends AbstractDAO implements ${declarationName}DAO {
		
			@Autowired
			private ${declarationName}Repository ${entityName}Repository;
	
			@Override
			public List<${declarationName}> findAll(){
				return ${entityName}Repository.findAll();
			}
		
			@Override
			public List<${declarationName}> findAll(Sort sort){
				return ${entityName}Repository.findAll(sort);
			}
		
			@Override
			public List<${declarationName}> findAllById(Iterable<${typeId}> ids){
				return ${entityName}Repository.findAllById(ids);
			}
		
			@Override
			public void flush(){
				${entityName}Repository.flush();
			}
		
			@Override
			public ${declarationName} saveAndFlush(${declarationName} entity){
				return ${entityName}Repository.saveAndFlush(entity);
			}
		
			@Override
			public ${declarationName} getOne(${typeId} id){
				return ${entityName}Repository.getOne(id);
			}
				
			@Override
			public Page<${declarationName}> findAll(Pageable pageable){
				return ${entityName}Repository.findAll(pageable);
			}
			
			@Override
			public ${declarationName} save(${declarationName} entity){
				return ${entityName}Repository.save(entity);
			}
			
			@Override
			public Optional<${declarationName}> findById(${typeId} id){
				return ${entityName}Repository.findById(id);
			}
			
			@Override
			public boolean existsById(${typeId} id){
				return ${entityName}Repository.existsById(id);
			}
			
			@Override
			public long count(){
				return ${entityName}Repository.count();
			}
			
			@Override
			public void deleteById(${typeId} id){
				${entityName}Repository.deleteById(id);
			}
			
			@Override
			public void delete(${declarationName} entity){
				${entityName}Repository.delete(entity);
			}
			
			@Override
			public List<${declarationName}> findAll(${declarationName} entity) {
				Example<${declarationName}> example = Example.of(entity);
		
				return  ${entityName}Repository.findAll(example);
			}
		
			@Override
			public Page<${declarationName}> findAll(${declarationName} entity, Pageable pageable) {
				Example<${declarationName}> example = Example.of(entity);
		
				return  ${entityName}Repository.findAll(example, pageable);
			}
		
			@Override
			public List<${declarationName}> findAll(${declarationName} entity, Sort sort) {
				Example<${declarationName}> example = Example.of(entity);
		
				return  ${entityName}Repository.findAll(example, sort);
			}			
		}
	
	</#assign>

	${classbody}
</#if>

