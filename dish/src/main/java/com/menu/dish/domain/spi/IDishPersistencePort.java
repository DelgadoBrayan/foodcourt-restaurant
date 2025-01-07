package com.menu.dish.domain.spi;

import com.menu.dish.domain.model.dish.Dish;

public interface IDishPersistencePort {
    void saveDish(Dish dish);

    Dish findDishById(Long id);

    void updateDish(Long id, Double price, String description);


}
