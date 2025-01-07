package com.menu.dish.infrastructure.out.jpa.adapter;

import com.menu.dish.domain.model.Dish;
import com.menu.dish.domain.spi.IDishPersistencePort;
import com.menu.dish.infrastructure.out.jpa.mapper.DishEntityMapper;
import com.menu.dish.infrastructure.out.jpa.repository.DishRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {
    private final DishRepository dishRepository;
    private final DishEntityMapper dishEntityMapper;

    @Override
    public void saveDish(Dish dish) { 
        dishRepository.save(dishEntityMapper.toEntity(dish)); 
    }
    @Override public Dish findDishById(Long id) { 
        return dishRepository.findById(id)
        .map(dishEntityMapper::toModel)
        .orElse(null); 
    }
    @Override
    public void updateDish(Long id, Double price, String description) {
        dishRepository.findById(id).ifPresent(dishEntity -> {
            dishEntity.setPrice(price);
            dishEntity.setDescription(description);
            dishRepository.save(dishEntity);
        });
        
    }

}
