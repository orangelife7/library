package com.example.demo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class CoreMapper extends ObjectMapper {

	private SimpleFilterProvider provider;

	{
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
