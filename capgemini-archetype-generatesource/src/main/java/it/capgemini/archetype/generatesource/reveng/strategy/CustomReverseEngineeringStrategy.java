package it.capgemini.archetype.generatesource.reveng.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.ForeignKey;
import org.hibernate.mapping.MetaAttribute;

public class CustomReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

	private static final Integer SQL_TYPE_TIMESTAMP = 1111;

	public CustomReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	@Override
	public String columnToPropertyName(TableIdentifier table, String column) {
		System.out.println("Column: " + column);

		if (column.startsWith("SEQU_")) {
			column = "id";
		}

		return super.columnToPropertyName(table, column);
	}

	@Override
	// Metodo utilizzato per aggiungere attributi durante la generazione delle
	// entità
	public Map<String, MetaAttribute> tableToMetaAttributes(final TableIdentifier tableIdentifier) {
		Map<String, MetaAttribute> metaAttributes = super.tableToMetaAttributes(tableIdentifier);

		if (metaAttributes == null) {
			metaAttributes = new HashMap<String, MetaAttribute>();
		}

		MetaAttribute extAttribute = new MetaAttribute("extends");

		extAttribute.addValue("BaseEntity");
		metaAttributes.put("extends", extAttribute);

		// Aggiungo un istruzione import alla generazione della classe
		MetaAttribute importAttribute = new MetaAttribute("extra-import");

		importAttribute.addValue("it.capgemini.archetype.entity.BaseEntity");

		metaAttributes.put("extra-import", importAttribute);

		return metaAttributes;
	}

//	@Override
//	public String tableToClassName(TableIdentifier tableIdentifier) {
//		String className = super.tableToClassName(tableIdentifier);
//		
//		if (className.contains(".Prz")) {
//			className = className.replace(".Prz", ".");
//		}
//		
//		return className;
//	}

	@SuppressWarnings("rawtypes")
	@Override
	public String foreignKeyToCollectionName(String keyname, TableIdentifier fromTable, List fromColumns,
			TableIdentifier referencedTable, List referencedColumns, boolean uniqueReference) {
		String propertyName = StringHelper.unqualify(tableToClassName(fromTable));

		String name = "lista" + propertyName;

		return name;
	}

//	@SuppressWarnings("rawtypes")
//	@Override
//	public String foreignKeyToEntityName(String keyname, TableIdentifier fromTable, List fromColumnNames,
//			TableIdentifier referencedTable, List referencedColumnNames, boolean uniqueReference) {
//		String originalName = super.foreignKeyToEntityName(keyname, fromTable, fromColumnNames, referencedTable,
//				referencedColumnNames, uniqueReference);
//		String name = originalName.substring(1);
//		
//		name = StringUtils.uncapitalize(name);
//		
//		// name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
//		// name = "lista" + name;
//		return name;
//	}

	@Override
	public String foreignKeyToManyToManyName(ForeignKey fromKey, TableIdentifier middleTable, ForeignKey toKey,
			boolean uniqueReference) {
		String propertyName = StringHelper.unqualify(tableToClassName(middleTable));

		String name = "lista" + propertyName;

		return name;

//		String name = super.foreignKeyToManyToManyName(fromKey, middleTable, toKey, uniqueReference);
//
//		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
//		name = "lista" + name.substring(0, name.length() - 1);
//
//		return name;
	}

	@Override
	// Metodo utilizzato per mappare i tipi dati letti dal DB e trasformarli in
	// tipi dati java
	public String columnToHibernateTypeName(TableIdentifier table, String columnName, int sqlType, int length,
			int precision, int scale, boolean nullable, boolean generatedIdentifier) {
		String type;

		// Trasformo il tipo dati timestamp in calendar.
		// Gli hibernate tools di default lo trasformerebbero in un oggetto
		// Serializable
		if (sqlType == SQL_TYPE_TIMESTAMP) {
			type = "calendar";
		} else {
			type = super.columnToHibernateTypeName(table, columnName, sqlType, length, precision, scale, nullable,
					generatedIdentifier);
		}

		return type;
	}

	@Override
	public boolean excludeColumn(TableIdentifier identifier, String columnName) {
		if (columnName.equals("COD_PGM_ULT_MOV")) {
			System.out.println("Colonna esclusa dalla generazione: " + columnName);

			return true;
		} else if (columnName.equals("COD_UTE_ULT_MOV")) {
			System.out.println("Colonna esclusa dalla generazione: " + columnName);

			return true;
		} else if (columnName.equals("DAT_ORA_ULT_MOV")) {
			System.out.println("Colonna esclusa dalla generazione: " + columnName);

			return true;
		}

		return false;
	}

	@Override
	public String tableToIdentifierPropertyName(TableIdentifier tableIdentifier) {
		return "id";
	}
}
