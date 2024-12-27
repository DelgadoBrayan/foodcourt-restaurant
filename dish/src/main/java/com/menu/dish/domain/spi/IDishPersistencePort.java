package com.menu.dish.domain.spi;

import com.menu.dish.domain.model.Dish;

public interface IDishPersistencePort {
    void saveDish(Dish dish);
    Dish findDishById(Long id);
}
