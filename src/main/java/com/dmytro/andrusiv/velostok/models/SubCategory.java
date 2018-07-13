package com.dmytro.andrusiv.velostok.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class SubCategory {
    @Id
    String id;
    String name;
    String description;
    String image;
    String categoryId;
    List<Product> products;
}
