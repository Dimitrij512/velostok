package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CategoryService cotegoryService;

    @Autowired
    ProductService productService;

    @PostMapping("/createCategory")
    Category createCategory(@RequestBody Category category){
        return  cotegoryService.createCategory(category);
    }

    @PostMapping("/createProduct")
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
