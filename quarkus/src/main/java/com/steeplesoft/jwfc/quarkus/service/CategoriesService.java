package com.steeplesoft.jwfc.quarkus.service;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Category;
import com.steeplesoft.jwfc.quarkus.repository.CategoryRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class CategoriesService {
    @Inject
    protected CategoryRepository repository;

    public List<Category> findAll() {
        return repository.listAll(Sort.by("name"));
    }

    public Category find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Category category) {
        repository.persist(category);
    }

    @Transactional
    public void update(Category category) {
        Category entity = find(category.getId());
        if (entity != null) {
            entity.setName(category.getName());
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
