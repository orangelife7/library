package com.example.demo.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BaseEntity;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.repository.CoreRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;

public abstract class CrudService<T extends BaseEntity> {

	public abstract CoreRepository<T, Long> getRepository();
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public T create(T entity) {
		beforeCreate(entity);
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
	public void update(Long id, Map<String, String> payload) {
		T existing = getRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("Entity with address id: " + id + " not found."));

		payload.forEach((name, value) -> {
			try {
				Field f = existing.getClass().getDeclaredField(name);
				if (f.isAnnotationPresent(Id.class))
					return;
				f.setAccessible(true);

				// pobierz zrzutowana wartosc
				Object castedValue = getCastedValue(f, value);
				f.set(existing, castedValue);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new RuntimeException("Error updating entity fields", e);
			}
		});

		getRepository().save(existing);
	}

	private Object getCastedValue(Field f, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		Class<?> fieldType = f.getType();
		if (fieldType == LocalDateTime.class) {
			return LocalDateTime.parse(value, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		}
		if(fieldType == Boolean.class) {
			return Boolean.valueOf(value);
		}
		if (fieldType == Integer.class) {
			return Integer.valueOf(value);
		}
		if(BaseEntity.class.isAssignableFrom(fieldType)) {
			return entityManager.getReference(fieldType, Long.valueOf(value));
		}
		return value;
	}

	@Transactional
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	protected CoreMapper getMapper() {
		return null;
	}

	protected void beforeCreate(T entity) {
	}
}
