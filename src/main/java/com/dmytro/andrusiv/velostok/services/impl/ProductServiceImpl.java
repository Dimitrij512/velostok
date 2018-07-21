package com.dmytro.andrusiv.velostok.services.impl;

import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.repositories.ProductRepository;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> findAllByCategory(String name) {
        return repository.findAllByCategory(name);
    }

    @Override
    public List<Product> findAllBySubCategoryId(String id) {
        return repository.findAllBySubCategoryId(id);
    }

    @Override
    public Product findOneByName(String name) {
        return repository.findOneByName(name);
    }

    @Override
    public Optional<Product> findOneById(String id) {
        return repository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.insert(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteById(String id) {
         repository.deleteById(id);
    }

}
