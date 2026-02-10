package com.example.demo.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class CoreMapper extends ObjectMapper {
	
	private static final List<String> ALWAYS_VISIBLE = List.of("id", "label");

	private static final long serialVersionUID = 1L;
	private SimpleFilterProvider provider;

	{
		JavaTimeModule javaTimeModule = new JavaTimeModule();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dtf));
		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dtf));

		registerModule(javaTimeModule);
		disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		provider = new SimpleFilterProvider();
		setFilterProvider(provider);
	}

	protected void addFilter(String filterName, SimpleBeanPropertyFilter filter) {
		provider.addFilter(filterName, filter);
	}

	protected SimpleBeanPropertyFilter filterOutAllExcept(String... propertyArray) {

		List<String> properties = new ArrayList<>(Arrays.asList(propertyArray));
		properties.addAll(ALWAYS_VISIBLE);
		String[] propertiesArr = properties.toArray(new String[0]);
		return SimpleBeanPropertyFilter.filterOutAllExcept(propertiesArr);
	}

	protected SimpleBeanPropertyFilter serializeAllExcept(String... propertyArray) {
		List<String> properties = new ArrayList<>(Arrays.asList(propertyArray));
		properties.removeAll(ALWAYS_VISIBLE);
		String[] propertiesArr = properties.toArray(new String[0]);
		return SimpleBeanPropertyFilter.serializeAllExcept(propertiesArr);
	}

}
