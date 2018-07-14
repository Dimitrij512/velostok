package com.dmytro.andrusiv.velostok.repositories;

import com.dmytro.andrusiv.velostok.models.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {

    SubCategory findOneByName(String name);
}
