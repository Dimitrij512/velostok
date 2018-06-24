package com.dmytro.andrusiv.velostok.repositories;

import com.dmytro.andrusiv.velostok.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findOneByName(String name);

    List<Product> findAllByCategory(String name);

}
