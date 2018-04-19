package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllProjects();

    Category findOneByName(String name);

    Optional<Category> findById(String id);

    Category createCategory(Category category);
}
