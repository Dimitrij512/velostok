package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.models.Product;
import com.dmytro.andrusiv.velostok.models.SubCategory;
import com.dmytro.andrusiv.velostok.models.SuperCategory;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import com.dmytro.andrusiv.velostok.services.api.SubCategoryService;
import com.dmytro.andrusiv.velostok.services.api.SuperCategoryService;
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
