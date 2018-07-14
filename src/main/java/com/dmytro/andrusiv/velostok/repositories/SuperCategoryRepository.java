package com.dmytro.andrusiv.velostok.repositories;

import com.dmytro.andrusiv.velostok.models.SuperCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperCategoryRepository extends MongoRepository<SuperCategory, String> {

    SuperCategory findOneByName(String name);
}
