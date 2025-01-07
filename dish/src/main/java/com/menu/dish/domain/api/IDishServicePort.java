package com.menu.dish.domain.api;

import com.menu.dish.domain.model.dish.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish);

    Dish findDishById(Long id);

    void updateDish(Long id, Double price, String description);

 
}
