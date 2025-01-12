package com.menu.dish.domain.spi;

import java.util.List;

import com.menu.dish.domain.model.dish.Dish;

public interface IDishPersistencePort {
    void saveDish(Dish dish);

    Dish findDishById(Long id);

    void updateDish(Long id, Double price, String description);

    void toggleDishAvailability(Long id, boolean isAvailable);

    List<Dish> listDishesByRestaurant(Long restaurantId, int page, int size, String category);

    List<Dish> findDishesByIds(List<Long> ids);
}
