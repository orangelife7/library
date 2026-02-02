package com.example.demo.service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredField;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BaseEntity;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.repository.CoreRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;

public abstract class CrudService<T extends BaseEntity> {

	public abstract CoreRepository<T, Long> getRepository();

	@Transactional
	public T save(T entity) {
		return getRepository().save(entity);
	}

	public Optional<T> findById(Long id) {
		return getRepository().findById(id);
	}

	public List<T> findAll() {
		return getRepository().findAll();
	}

	public String getListJson() throws JsonProcessingException {
		List<T> list = findAll();
		ObjectMapper mapper = getMapper();
		return mapper.writeValueAsString(list);
	}
	
	public String getDetailsJson(Long id) throws JsonProcessingException {
		T entity = findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
		ObjectMapper mapper = getMapper();
		return mapper.writeValueAsString(entity);
	}

	@Transactional
	public void update(Long id, Map<String, Object> payload) {
		T existing = getRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("Entity with address id: " + id + " not found."));
	
		payload.forEach((name, value) -> {
			try {
				Field f = existing.getClass().getDeclaredField(name);
				if(f.isAnnotationPresent(Id.class)) return;
				f.setAccessible(true);
				if (f.getType() == LocalDateTime.class && value instanceof String) {
				    String s = (String) value;
				    value = s.isEmpty() ? null
				    : LocalDateTime.parse(s, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
				}
				f.set(existing, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new RuntimeException("Error updating entity fields", e);
			}
		});
		
		getRepository().save(existing);
	}

	@Transactional
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	protected CoreMapper getMapper() {
		return null;
	}
}


