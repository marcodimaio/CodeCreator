package ${DTOPackage};

// Generated ${date}

<#assign classbody>
	<#assign declarationName = pojo.importType(pojo.getDeclarationName())+"DTO">
	
	<#-- Ciclo per generare gli import -->
	<#assign importCalendar=true>

	<#foreach property in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(property, "gen-property", true)>
			<#assign javaTypeName = pojo.getJavaTypeName(property, jdk5)>
			
			<#if javaTypeName=="Calendar" && importCalendar>
				import java.util.Calendar;

				<#assign importCalendar=false>
			</#if>		
		</#if>
	</#foreach>	

	public class ${declarationName} extends AbstractDTO {
		<#foreach property in pojo.getAllPropertiesIterator()>
		    <#if !c2h.isCollection(property)>
				public static final String ${property.name?upper_case} ="${property.name}";
			</#if>
		</#foreach>

		<#-- Ciclo per generare gli attributi di classe -->
		<#foreach property in pojo.getAllPropertiesIterator()>
			<#if pojo.getMetaAttribAsBool(property, "gen-property", true)>
		        <#if !c2h.isCollection(property)>
					<#-- Verifico se il campo è un tipo JAVA o un oggetto -->
					<#if property.value.typeName?exists>
			        	<#assign javaTypeName = pojo.getJavaTypeName(property, jdk5)>
					<#else>
			        	<#assign javaTypeName = pojo.getJavaTypeName(property, jdk5) + "DTO">
					</#if>
	
					${pojo.getFieldModifiers(property)} ${javaTypeName} ${property.name};
				</#if>
			</#if>
		</#foreach>
		
		<#-- Costrutturo di default -->
	    public ${declarationName}() {
		}
		
		<#assign parametriCostruttore>
			<#-- Costruisco i parametri d'ingresso al costruttore -->
			<#list pojo.getPropertiesForMinimalConstructor() as field>
		        <#if !c2h.isCollection(field)>
					<#-- Verifico se il campo è un tipo JAVA o un oggetto -->
					<#if field.value.typeName?exists>
			        	<#assign javaTypeName = pojo.getJavaTypeName(field, jdk5)>
					<#else>
			        	<#assign javaTypeName = pojo.getJavaTypeName(field, jdk5) + "DTO">
					</#if>
					<#if field?has_next>
						<#-- Metto la virgola solo se ho un altro parametro dopo quello attuale -->				
						${javaTypeName} ${c2j.keyWordCheck(field.name)},
					<#else>
						${javaTypeName} ${c2j.keyWordCheck(field.name)}
					</#if>
				</#if>
			</#list>		
		</#assign>
		
		<#assign corpoCostruttore>
			<#-- Costruisco il corpo del costruttore -->
			<#foreach field in pojo.getPropertiesForMinimalConstructor()>
		        <#if !c2h.isCollection(field)>
					this.${c2j.keyWordCheck(field.name)} = ${c2j.keyWordCheck(field.name)};
				</#if>
			</#foreach>		
		</#assign>
		
		<#-- Costruttore con solo i campi obbligatori dell'entity associato -->
		public ${declarationName}(${parametriCostruttore}) {
			${corpoCostruttore}
		}

		<#-- Ciclo per generare metodi set e get -->
		<#-- Ciclo due volte consecutivamente semplicemente per strutturare il codice in maniera corretta.
		Così infatti vengono scritte prima le proprietà della classe e poi i metodi.
		Avrei potuto ciclare anche una sola volta ma in quel caso le proprietà sarebbero state 
		mischiate con i metodi-->
		<#foreach property in pojo.getAllPropertiesIterator()>
			<#if pojo.getMetaAttribAsBool(property, "gen-property", true)>
		        <#if !c2h.isCollection(property)>
		        	<#if property.value.typeName?exists>
			        	<#assign javaTypeName = pojo.getJavaTypeName(property, jdk5)>
			        	<#assign methodNameSuffix = "">
					<#else>
			        	<#assign javaTypeName = pojo.getJavaTypeName(property, jdk5) + "DTO">
			        	<#assign methodNameSuffix = "">
					</#if>

				    ${pojo.getPropertyGetModifiers(property)} ${javaTypeName} ${pojo.getGetterSignature(property)}${methodNameSuffix}() {
				        return this.${property.name}${methodNameSuffix};
				    }
				    
				    ${pojo.getPropertySetModifiers(property)} void set${pojo.getPropertyName(property)}${methodNameSuffix}(${javaTypeName} ${property.name}${methodNameSuffix}) {
				        this.${property.name}${methodNameSuffix} = ${property.name}${methodNameSuffix};
				    }
				</#if>
				
			</#if>
		</#foreach>
	}
</#assign>

${classbody}


