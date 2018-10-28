package com.dmytro.andrusiv.velostok.models;

import com.dmytro.andrusiv.velostok.enums.ApplRole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private ApplRole role;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String image;
}
