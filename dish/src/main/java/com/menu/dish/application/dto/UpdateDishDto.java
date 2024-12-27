package com.menu.dish.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateDishDto {
    @NotNull 
    @Min(value = 1, message = "Price must be greater than 0") 
    private int price; 
    @NotNull 
    @Size(min = 1, max = 255) 
    private String description; 
    public int getPrice() { return price; } 
    public void setPrice(int price) { this.price = price; } 
    public String getDescription() { return description; } 
    public void setDescription(String description) { this.description = description; }
}
