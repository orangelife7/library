package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

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
	public void update(Long id, T entity) {
		T existingEntity = getRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("Entity with address id: " + id + " not found."));
		for (Field field : entity.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object newValue = field.get(entity);
				if (newValue != null && !field.isAnnotationPresent(Id.class)) {
					field.set(existingEntity, newValue);
				}

			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error updating entity fields", e);
			}
		}
		getRepository().save(existingEntity);
	}

	@Transactional
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	protected CoreMapper getMapper() {
		return null;
	}
}


