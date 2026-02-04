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

import com.example.demo.entity.BaseEntity;
import com.example.demo.pojo.FieldInfo;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@RestController
public class ConfigurationController {
	
	 @GetMapping("/field-configuration")
	    public Map<String, Map<String, FieldInfo>> fieldConfiguration() {

	        Map<String, Map<String, FieldInfo>> result = new HashMap<>();

	        Set<Class<?>> entities =
	                new Reflections("com.example.demo.entity")
	                        .getTypesAnnotatedWith(Entity.class);

	        for (Class<?> entity : entities) {

	            Map<String, FieldInfo> fields = new HashMap<>();

	            for (Field field : entity.getDeclaredFields()) {
	                String type = mapType(field.getType());
	                boolean nullable = !field.isAnnotationPresent(NotNull.class);
	                fields.put(field.getName(), new FieldInfo(type, nullable));
	            }

	            result.put(StringUtils.uncapitalize(entity.getSimpleName()), fields);
	        }

	        return result;
	    }

	    private String mapType(Class<?> type) {
	        if (type == LocalDateTime.class) return "localDateTime";
	        if (type == boolean.class || type == Boolean.class) return "boolean";
	        
	        if (BaseEntity.class.isAssignableFrom(type)) return "entity";
	        
	        return "text";
	        
	        
	    }
	}
