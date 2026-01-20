package com.example.demo.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class CoreMapper extends ObjectMapper {

	private SimpleFilterProvider provider;

	{
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

		registerModule(javaTimeModule);
		disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		provider = new SimpleFilterProvider();
		setFilterProvider(provider);
	}

	protected void addFilter(String filterName, SimpleBeanPropertyFilter filter) {
		provider.addFilter(filterName, filter);
	}

	protected SimpleBeanPropertyFilter filterOutAllExcept(String... propertyArray) {
		return SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);
	}

	protected SimpleBeanPropertyFilter serializeAllExcept(String... propertyArray) {
		return SimpleBeanPropertyFilter.serializeAllExcept(propertyArray);
	}

}
