package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> findAllByCategory(String name);

    List<Product> findAllBySubCategoryId(String id);

    List<Product> findAllByCategoryId(String id);

    Product findOneByName(String name);

    Optional<Product> findOneById(String id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteById(String id);



}
