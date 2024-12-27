package com.menu.dish.application.handler;

import org.springframework.stereotype.Service;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.application.mapper.DishMapper;
import com.menu.dish.domain.model.Dish;
import com.menu.dish.domain.usecase.DishUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DishHandler {
    private final DishUseCase dishUseCase;

    public void createDish(DishDto dishDto) {
      Dish dish = DishMapper.INSTANCE.toDish(dishDto);
        dishUseCase.createDish(dish);
       
    }
    public void updateDish(Long id, UpdateDishDto updateDishDTO) {  
        Dish dish = dishUseCase.findDishById(id); 
        Dish updatedDish = DishMapper.INSTANCE.updateDishFromDTO(dish, updateDishDTO); 
        dishUseCase.updateDish(id, updatedDish.getDishInfo().getPrice(), updatedDish.getDishInfo().getDescription());
    }
}
