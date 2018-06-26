package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @PostMapping("/category")
    Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PostMapping("/product")
    Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/category")
    Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @PutMapping("/product")
    Product updateProduct(@RequestBody  Product product) { return productService.updateProduct(product);
    }

    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable String id) {
        categoryService.deleteById(id);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }

}
