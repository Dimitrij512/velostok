package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.*;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import com.dmytro.andrusiv.velostok.services.api.ProductService;
import com.dmytro.andrusiv.velostok.services.api.SubCategoryService;
import com.dmytro.andrusiv.velostok.services.api.SuperCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    SuperCategoryService superCategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ProductService productService;


    @GetMapping("/allSuperCategories")
    List<SuperCategory> getAllSuperCategories() {
        return superCategoryService.getAllSuperCategories();
    }

    @GetMapping("/allCategories")
    List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/allSubCategories")
    List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/superCategory/{id}")
    SuperCategory findSuperCategoryById(@PathVariable String id){
        return superCategoryService.findOneById(id).get();
    }

    @GetMapping("/category/{id}")
    Category findCategoryById(@PathVariable String id) {
        return categoryService.findOneById(id).get();
    }

    @GetMapping("/subCategory/{id}")
    SubCategory findSubCategoryById(@PathVariable String id) {
        return subCategoryService.findOneById(id).get();
    }

    @GetMapping("/allProducts")
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    Product findOneById(@PathVariable String productId) {
        return productService.findOneById(productId).get();
    }

    @GetMapping("/products/category/{id}")
    List<Product> findAllProductByCategoryId(@PathVariable String id){
        return productService.findAllByCategoryId(id);
    }

    @GetMapping("/subCategory/category/{id}")
    List<SubCategory> findAllSubCategoryByCategoryId(@PathVariable String id){
        return subCategoryService.findAllByCategryId(id);
    }

    @GetMapping("/category/superCategory/{id}")
    List<Category> findAllCategoryBySuperCategoryId(@PathVariable String id){
       return categoryService.findAllBySuperCategoryId(id);
    }

    //test
    @GetMapping("/user")
    public Principal user(Principal principal) {
        User user = new User();
        System.out.println(principal);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        System.out.println(token);
        return principal;
    }

}
