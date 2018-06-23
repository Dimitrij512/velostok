package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProjects();

    List<Product> findAllByCategory(String name);

    Product findOneByName(String name);

    Optional<Product> findOneById(String id);

    Product createProduct(Product product);


}
