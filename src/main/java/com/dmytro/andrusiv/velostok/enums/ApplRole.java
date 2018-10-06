package com.dmytro.andrusiv.velostok.enums;

public enum ApplRole {

    ADMIN("адміністратор"), USER("клієнт");

    private String role;

    private ApplRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
