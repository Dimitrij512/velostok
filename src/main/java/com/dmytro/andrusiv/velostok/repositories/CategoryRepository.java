package com.dmytro.andrusiv.velostok.repositories;

import com.dmytro.andrusiv.velostok.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findOneByName(String name);

    List<Category> findAllBySuperCategoryId(String id);
}
