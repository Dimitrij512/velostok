package com.dmytro.andrusiv.velostok.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Category {
    @Id
    String id;
    String name;
    List<Product> products;
}
