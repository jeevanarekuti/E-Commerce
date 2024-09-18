package com.example.ecommerce.models;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;

}
