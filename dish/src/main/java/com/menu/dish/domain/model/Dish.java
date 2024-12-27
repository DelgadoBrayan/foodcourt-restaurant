package com.menu.dish.domain.model;


public class Dish {
    private Long id;
    private DishInfo dishInfo;
    private RestaurantAssociation restaurantAssociation;
    private boolean active;

    public Dish(Long id, DishInfo dishInfo, RestaurantAssociation restaurantAssociation, boolean active) {
        this.id = id;
        this.dishInfo = dishInfo;
        this.restaurantAssociation = restaurantAssociation;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public DishInfo getDishInfo() { return dishInfo; }
    public void setDishInfo(DishInfo dishInfo) { this.dishInfo = dishInfo; }

    public RestaurantAssociation getRestaurantAssociation() { return restaurantAssociation; }
    public void setRestaurantAssociation(RestaurantAssociation restaurantAssociation) { this.restaurantAssociation = restaurantAssociation; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public void updatePrice(int price) { 
        this.dishInfo.setPrice(price); 
    } 
    public void updateDescription(String description) { 
        this.dishInfo.setDescription(description); 
    }
}
