package com.dmytro.andrusiv.velostok.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class SuperCategory {

    @Id
    String id;
    String name;
    String description;
    String image;
    List<Category> categories = new ArrayList<>();

}
