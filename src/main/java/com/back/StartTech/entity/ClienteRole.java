package com.back.StartTech.entity;

public enum ClienteRole {

    ADMIN("admin"),

    USER("user");

    private String role;

    ClienteRole(String role){
        this.role = role;

    }

    public String getRole() {
        return role;
    }
}
