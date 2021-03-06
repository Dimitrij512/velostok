package com.dmytro.andrusiv.velostok.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Category {
    @Id
    String id;
    String name;
    String description;
    String image;
    String superCategoryId;
    String superCategoryName;
    List<SubCategory> subCategories = new ArrayList<>();

}
