package com.dmytro.andrusiv.velostok.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    @Id
    String id;
    String name;
    String title;
    String categoryId;
    String categoryName;
    int price;
    boolean isAvailable;
    String description;
    String image;
    String largeImage;

}
