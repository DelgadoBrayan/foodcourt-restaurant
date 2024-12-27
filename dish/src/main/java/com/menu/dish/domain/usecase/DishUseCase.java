package com.menu.dish.domain.usecase;

import com.menu.dish.domain.model.Dish;
import com.menu.dish.domain.spi.IDishPersistencePort;

public class DishUseCase {
    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    public void createDish(Dish dish) {
        if (dish.getDishInfo().getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        if (dish.getRestaurantAssociation().getRestaurantId() == null) {
            throw new IllegalArgumentException("Restaurant ID cannot be null");
        }

        dish.setActive(true);

        dishPersistencePort.saveDish(dish);
    }

    public Dish findDishById(Long id) {
        return dishPersistencePort.findDishById(id);
    }

    public void updateDish(Long id, int price, String description) {
        Dish dish = dishPersistencePort.findDishById(id);
        if (dish == null) {
            throw new IllegalArgumentException("Dish not found");
        }
        dish.updatePrice(price);
        dish.updateDescription(description);
        dishPersistencePort.saveDish(dish);
    }

}

