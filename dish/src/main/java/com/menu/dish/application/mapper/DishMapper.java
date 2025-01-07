package com.menu.dish.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.domain.model.dish.Dish;
import com.menu.dish.domain.model.dish.DishInfo;
import com.menu.dish.domain.model.dish.RestaurantAssociation;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    default Dish toDish(DishDto dishDto) {
        if (dishDto == null) {return null;}

        DishInfo dishInfo = new DishInfo(dishDto.getName(), dishDto.getPrice(), dishDto.getDescription(), dishDto.getUrlImage(), dishDto.getCategory());
        RestaurantAssociation restaurantAssociation = new RestaurantAssociation(dishDto.getRestaurantId());
        return new Dish(null, dishInfo, restaurantAssociation, true);
    }

    default DishDto toDishDTO(Dish dish) {
        if (dish == null) {return null;}

        DishDto dishDto = new DishDto();
        dishDto.setName(dish.getDishInfo().getName());
        dishDto.setPrice(dish.getDishInfo().getPrice());
        dishDto.setDescription(dish.getDishInfo().getDescription());
        dishDto.setUrlImage(dish.getDishInfo().getUrlImage());
        dishDto.setCategory(dish.getDishInfo().getCategory());
        dishDto.setRestaurantId(dish.getRestaurantAssociation().getRestaurantId());
        dishDto.setActive(dish.isActive()); 
        return dishDto;
    }

    default Dish updateDishFromDTO(Dish dish, UpdateDishDto updateDishDTO) { 
        if (dish == null || updateDishDTO == null) { 
            return null; 
        } 
        dish.updatePrice(updateDishDTO.getPrice()); 
        dish.updateDescription(updateDishDTO.getDescription()); 
        return dish; 
    }

}
