package com.dmytro.andrusiv.velostok.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    String id;
    String name;
    String description;
    int price;
}
