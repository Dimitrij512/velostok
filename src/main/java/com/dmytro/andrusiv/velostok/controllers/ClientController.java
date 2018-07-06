package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/allCategories")
    List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/allProducts")
    List<Product> getAllProducts(){
        return  productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    Product findOneById(@PathVariable String productId){
        return productService.findOneById(productId).get();
    }

    @GetMapping("/products/category/{categoryName}")
    List<Product> findAllByCategory(@PathVariable String categoryName){
        return productService.findAllByCategory(categoryName);
    }

    @GetMapping("/products/{name}")
    List<Product> findAllProductsByCategory(@PathVariable String name){
        return productService.findAllByCategory(name);
    }

}
