<#-- // Fields -->

<#-- // Era possibile unificare i due cicli ma in questo modo si evita che  
le costanti vengano inserite tra gli attributi della classe -->
<#foreach property in pojo.getAllPropertiesIterator()>
    <#if !c2h.isCollection(property)>
		public static final String ${property.name?upper_case} ="${property.name}";
	</#if>
</#foreach>

<#foreach field in pojo.getAllPropertiesIterator()>
	<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
		<#if pojo.hasMetaAttribute(field, "field-description")>    /**
		     ${pojo.getFieldJavaDoc(field, 0)}
		     */
		 </#if>    ${pojo.getFieldModifiers(field)} ${pojo.getJavaTypeName(field, jdk5)} ${c2j.keyWordCheck(field.name)}<#if pojo.hasFieldInitializor(field, jdk5)> = ${pojo.getFieldInitialization(field, jdk5)}</#if>;
	</#if>
</#foreach>
