package com.menu.dish.application.handler;

import org.springframework.stereotype.Service;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.application.mapper.DishMapper;
import com.menu.dish.domain.api.IDishServicePort;
import com.menu.dish.domain.model.Dish;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DishHandler {

    private final IDishServicePort dishServicePort;

    public void createDish(DishDto dishDto) {
        Dish dish = DishMapper.INSTANCE.toDish(dishDto);
        dishServicePort.saveDish(dish);
    }

    public void updateDish(Long id, UpdateDishDto updateDishDTO) {
        Dish dish = dishServicePort.findDishById(id);
        Dish updatedDish = DishMapper.INSTANCE.updateDishFromDTO(dish, updateDishDTO);
        dishServicePort.updateDish(id, updatedDish.getDishInfo().getPrice(), updatedDish.getDishInfo().getDescription());
    }


}
