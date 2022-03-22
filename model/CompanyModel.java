package com.example.safarirides.model;

public class CompanyModel {

    String name;
    String motto;
    String services;
    String image;
    int id;

    public CompanyModel(String name, String motto, String services, String image, int id) {
        this.name = name;
        this.motto = motto;
        this.services = services;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getMotto() {
        return motto;
    }

    public String getServices() {
        return services;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
