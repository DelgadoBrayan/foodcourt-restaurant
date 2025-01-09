package com.menu.dish.domain.api;

import java.util.List;

import com.menu.dish.domain.model.dish.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish);

    Dish findDishById(Long id);

    void updateDish(Long id, Double price, String description);

    void toggleDishAvailability(Long id, boolean isAvailable);

    List<Dish> listDishesByRestaurant(Long restaurantId, int page, int size, String category);
}
