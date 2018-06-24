package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    Category findOneByName(String name);

    Optional<Category> findOneById(String id);

    Category createCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);



}
