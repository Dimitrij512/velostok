package com.dmytro.andrusiv.velostok.enums;

public enum ApplRole {

    ADMIN("адміністратор"), USER("клієнт"),
    FACEBOOK("фейсбук");

    private String role;

    ApplRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
