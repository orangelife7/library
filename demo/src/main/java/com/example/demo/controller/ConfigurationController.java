package com.example.demo.controller;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;

@RestController
public class ConfigurationController {
	
	 @GetMapping("/field-configuration")
	    public Map<String, Map<String, String>> fieldConfiguration() {

	        Map<String, Map<String, String>> result = new HashMap<>();

	        Set<Class<?>> entities =
	                new Reflections("com.example.demo.entity")
	                        .getTypesAnnotatedWith(Entity.class);

	        for (Class<?> entity : entities) {

	            Map<String, String> fields = new HashMap<>();

	            for (Field field : entity.getDeclaredFields()) {
	                fields.put(field.getName(), mapType(field.getType()));
	            }

	            result.put(StringUtils.uncapitalize(entity.getSimpleName()), fields);
	        }

	        return result;
	    }

	    private String mapType(Class<?> type) {
	        if (type == LocalDateTime.class) return "localDateTime";
	        if (type == boolean.class || type == Boolean.class) return "boolean";
	        return "text";
	    }
	}
