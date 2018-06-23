package com.dmytro.andrusiv.velostok.services.impl;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.repositories.CategoryRepository;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public Category findOneByName(String name) {
        return repository.findOneByName(name);
    }

    @Override
    public Optional<Category> findOneById(String id) {
        return repository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }
}
