package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.models.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    List<SubCategory> getAllSubCategory();

    SubCategory findOneByName(String name);

    Optional<SubCategory> findOneById(String id);

    SubCategory createSubCategory(SubCategory subCategory);

    SubCategory updateSubCategory(SubCategory subCategory);

    void deleteById(String id);
}
