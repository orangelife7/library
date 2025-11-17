package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.BaseEntity;
import com.example.demo.service.CrudService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public abstract class CrudController<T extends BaseEntity> {

	public abstract CrudService<T> getService();

	@PostMapping
	public T save(@RequestBody T entity) {
		return getService().save(entity);
	}

	@GetMapping("/list")
	public List<T> findAll() {
		return getService().findAll();
	}
	
	@GetMapping("/{id}")
	public T findById(@PathVariable Long id) {
		return getService().findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
	}
	
	@PostMapping("/{id}/update")
	public void update(@PathVariable Long id, @RequestBody T entity) {
		getService().update(id, entity);
	}
	
	@PostMapping("/{id}/delete")
	public void delete(@PathVariable Long id) {
		getService().delete(id);
	}
}





