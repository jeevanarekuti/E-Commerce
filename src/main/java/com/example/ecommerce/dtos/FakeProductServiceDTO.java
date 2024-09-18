package com.example.ecommerce.dtos;

import lombok.Data;

@Data
public class FakeProductServiceDTO {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
