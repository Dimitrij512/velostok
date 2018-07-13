package com.dmytro.andrusiv.velostok.repositories;

import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.models.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {

    List<Product> findAllProduct();

    SubCategory findOneByName(String name);
}
