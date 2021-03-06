package com.dmytro.andrusiv.velostok.services.impl;

import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.models.SubCategory;
import com.dmytro.andrusiv.velostok.repositories.SubCategoryRepository;
import com.dmytro.andrusiv.velostok.services.api.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository repository;

    @Override
    public List<SubCategory> getAllSubCategories() {
        return repository.findAll();
    }

    @Override
    public List<SubCategory> findAllByCategryId(String id) {
        return repository.findAllByCategoryId(id); }

    @Override
    public SubCategory findOneByName(String name) {
        return repository.findOneByName(name);
    }

    @Override
    public Optional<SubCategory> findOneById(String id) {
        return repository.findById(id);
    }

    @Override
    public SubCategory createSubCategory(SubCategory subCategory) {
        return repository.insert(subCategory);
    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory) {
        return repository.save(subCategory);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
