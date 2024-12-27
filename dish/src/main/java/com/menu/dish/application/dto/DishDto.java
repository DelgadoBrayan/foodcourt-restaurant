package com.menu.dish.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishDto {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Min(value = 1, message = "Price must be greater than 0")
    private int price;

    @NotNull
    @Size(min = 1, max = 255)
    private String description;

    @NotNull
    @Size(min = 1, max = 255)
    private String urlImage;

    @NotNull
    @Size(min = 1, max = 50)
    private String category;

    @NotNull
    private Long restaurantId;

}
