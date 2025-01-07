package com.menu.dish.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menu.dish.domain.model.Dish;
import com.menu.dish.infrastructure.out.jpa.entity.DishEntity;

@Mapper(componentModel = "spring")
public interface DishEntityMapper {

    DishEntityMapper INSTANCE = Mappers.getMapper(DishEntityMapper.class);

    @Mapping(source = "dishInfo.name", target = "name")
    @Mapping(source = "dishInfo.price", target = "price")
    @Mapping(source = "dishInfo.description", target = "description")
    @Mapping(source = "dishInfo.urlImage", target = "urlImage")
    @Mapping(source = "dishInfo.category", target = "category")
    @Mapping(source = "restaurantAssociation.restaurantId", target = "restaurantId")
    DishEntity toEntity(Dish dish);

    @Mapping(source = "name", target = "dishInfo.name")
    @Mapping(source = "price", target = "dishInfo.price")
    @Mapping(source = "description", target = "dishInfo.description")
    @Mapping(source = "urlImage", target = "dishInfo.urlImage")
    @Mapping(source = "category", target = "dishInfo.category")
    @Mapping(source = "restaurantId", target = "restaurantAssociation.restaurantId")
    Dish toModel(DishEntity dishEntity);
}
