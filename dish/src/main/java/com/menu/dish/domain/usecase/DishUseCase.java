package com.menu.dish.domain.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.menu.dish.domain.api.IDishServicePort;
import com.menu.dish.domain.model.dish.Dish;
import com.menu.dish.domain.spi.IDishPersistencePort;
import com.menu.dish.infrastructure.exception.InvalidDishException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    @Override
    public void saveDish(Dish dish) {
        if (dish.getDishInfo().getPrice() <= 0) {
           throw new InvalidDishException("El precio debe ser mayor a 0");
        }

        if (dish.getRestaurantAssociation().getRestaurantId() == null) {
            throw new InvalidDishException("El ID del restaurante no puede ser nulo");
        }

        dish.setActive(true);

         dishPersistencePort.saveDish(dish);
    }

    @Override
    public Dish findDishById(Long id) {
        return dishPersistencePort.findDishById(id);
    }

    @Override
    public void updateDish(Long id, Double price, String description) {
        Dish dish = dishPersistencePort.findDishById(id);
        if (dish == null) {
            throw new InvalidDishException("Plato no encontrado");
        }
        dish.getDishInfo().setPrice(price);
        dish.getDishInfo().setDescription(description);
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void toggleDishAvailability(Long id, boolean isAvailable) {
        Dish dish = dishPersistencePort.findDishById(id);

        if (dish == null) {
            throw new InvalidDishException("Plato no encontrado");
        }

        dish.setActive(isAvailable);
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public List<Dish> listDishesByRestaurant(Long restaurantId, int page, int size, String category) {
        
        return dishPersistencePort.listDishesByRestaurant(restaurantId, page, size, category);
    }

}
