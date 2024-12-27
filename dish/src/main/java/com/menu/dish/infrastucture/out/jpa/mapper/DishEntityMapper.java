package com.menu.dish.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.menu.dish.domain.model.Dish;
import com.menu.dish.infrastucture.out.jpa.entity.DishEntity;

@Mapper
public interface DishEntityMapper {

    DishEntityMapper INSTANCE = Mappers.getMapper(DishEntityMapper.class);

    DishEntity toEntity(Dish dish);
    Dish toModel(DishEntity dishEntity);
}
