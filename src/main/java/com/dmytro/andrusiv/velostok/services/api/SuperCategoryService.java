package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.SuperCategory;

import java.util.List;
import java.util.Optional;

public interface SuperCategoryService {

    List<SuperCategory> getAllSuperCategories();

    SuperCategory findOneByName(String name);

    Optional<SuperCategory> findOneById(String id);

    SuperCategory createSuperCategory(SuperCategory superCategory);

    SuperCategory updateSuperCategory(SuperCategory superCategory);

    void deleteById(String id);

}
