package it.capgemini.archetype.srv.mapper.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import it.capgemini.archetype.srv.mapper.converter.ToUpperCaseConverter;

@Configuration
public class ModelMapperConfig {
	private ModelMapper modelMapper;

	public ModelMapperConfig() {
		modelMapper = new ModelMapper();
		final ToUpperCaseConverter toUpperCaseConverter = new ToUpperCaseConverter();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	@Bean(name = "modelMapper")
	public ModelMapper getModelMapper() {
		return modelMapper;
	}
}
