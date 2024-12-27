package com.menu.dish.domain.model;


public class RestaurantAssociation {
    private Long restaurantId;

    public RestaurantAssociation(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
}