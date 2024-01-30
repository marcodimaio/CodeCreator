package it.capgemini.archetype.srv.mapper.converter;

import org.modelmapper.AbstractConverter;

public class ToUpperCaseConverter extends AbstractConverter<String, String> {
	@Override
	protected String convert(String source) {
		return source == null ? null : source.toUpperCase();
	}

}
