package com.dmytro.andrusiv.velostok.services.impl;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.models.SuperCategory;
import com.dmytro.andrusiv.velostok.repositories.SuperCategoryRepository;
import com.dmytro.andrusiv.velostok.services.api.SuperCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperCategoryServiceImpl implements SuperCategoryService {

    @Autowired
    SuperCategoryRepository repository;

    @Override
    public List<SuperCategory> getAllSuperCategory() {
        return repository.findAll();
    }

    @Override
    public SuperCategory findOneByName(String name) {
        return repository.findOneByName(name);
    }

    @Override
    public Optional<SuperCategory> findOneById(String id) {
        return repository.findById(id);
    }

    @Override
    public SuperCategory createSuperCategory(SuperCategory superCategory) {
        return repository.insert(superCategory);
    }

    @Override
    public SuperCategory updateSuperCategory(SuperCategory superCategory) {
        return repository.save(superCategory);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);

    }
}
