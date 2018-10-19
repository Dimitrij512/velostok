package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.*;
import com.dmytro.andrusiv.velostok.services.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    SuperCategoryService superCategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping("/user")
    User findUser(@PathVariable String userEmail){
        return userService.findOneByEmail(userEmail);
    }

    @PostMapping("/user")
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/superCategory")
    SuperCategory createSuperCategory(@RequestBody SuperCategory superCategory) {
        return superCategoryService.createSuperCategory(superCategory);
    }

    @PostMapping("/category")
    Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PostMapping("/subCategory")
    SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.createSubCategory(subCategory);
    }

    @PostMapping("/product")
    Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/user")
    User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PutMapping("/superCategory")
    SuperCategory updateSuperCategory(@RequestBody SuperCategory superCategory) {
        return superCategoryService.updateSuperCategory(superCategory);
    }

    @PutMapping("/category")
    Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @PutMapping("/subCategory")
    SubCategory updateSubCategory(@RequestBody SubCategory subCategory){
        return subCategoryService.updateSubCategory(subCategory);
    }

    @PutMapping("/product")
    Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/user")
    void deleteUser(@PathVariable String userId){ userService.deleteById(userId); }

    @DeleteMapping("/superCategory/{id}")
    void deleteSuperCategory(@PathVariable String id){
        superCategoryService.deleteById(id);
    }

    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable String id) {
        categoryService.deleteById(id);
    }

    @DeleteMapping("/subCategory/{id}")
    void deleteSubCategory(@PathVariable String id){
        subCategoryService.deleteById(id);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }

}
