package com.menu.dish.application.dto;

import lombok.Data;

@Data
public class DishDto {
    private String name;
    private Double price;
    private String description;
    private String urlImage;
    private String category;
    private Long restaurantId;
    private Boolean active;
}
