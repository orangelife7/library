package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BaseEntity;
import com.example.demo.service.CrudService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public abstract class CrudController<T extends BaseEntity> {

	public abstract CrudService<T> getService();

	@PostMapping("/create")
	public void save(@RequestBody T entity) {
		getService().save(entity);
	}

	/*
	@GetMapping("/list")
	public List<T> findAll() {
		return getService().findAll();
	}
	*/

	@GetMapping("/list")
	public String listJson() throws JsonProcessingException {
		return getService().getListJson();
	}
	
	@GetMapping("/{id}")
	public String detailsJson(@PathVariable Long id) throws JsonProcessingException {
		return getService().getDetailsJson(id);
	}

	/*
	@GetMapping("/{id}")
	public T findById(@PathVariable Long id) {
		return getService().findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
	}
	*/

	@PostMapping("/{id}/update")
	public void update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
		getService().update(id, payload);
	}

	@PostMapping("/{id}/delete")
	public void delete(@PathVariable Long id) {
		getService().delete(id);
	}
	
	@GetMapping("/{fieldName}/type")
	public ResponseEntity<String> fieldType(@PathVariable String fieldName) {

	    String fieldType = getFieldType(fieldName);
	    
	    return ResponseEntity.ok(String.format( "{\"data\" : \"%s\"}", fieldType));
	}
	
	private Class<?> getEntityClass() {
	    return (Class<?>) ((java.lang.reflect.ParameterizedType)
	            getClass().getGenericSuperclass())
	            .getActualTypeArguments()[0];
	}
	
	private String getFieldType(String fieldName) {
		try {
	        Class<?> entityClass = getEntityClass();

	        Class<?> fieldType = entityClass.getDeclaredField(fieldName).getType();

	        if (java.time.LocalDateTime.class.equals(fieldType)) {
	            return "localDateTime";
	        }
	        if (boolean.class.equals(fieldType) || Boolean.class.equals(fieldType)) {
	            return "boolean";
	        }
	    } catch (Exception ignored) {
	        
	    }

	    return "text";
	}
}
