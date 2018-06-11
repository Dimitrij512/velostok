package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.Category;
import com.dmytro.andrusiv.velostok.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/allCategories")
    List<Category> getAllCategory() {
        return categoryService.getAllProjects();
    }

    @GetMapping("/test")
    String test() {

        return "test, test, test";
    }

}
