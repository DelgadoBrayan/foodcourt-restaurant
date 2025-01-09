package com.menu.dish.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishActive;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.domain.model.dish.Dish;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    @Mapping(source = "name", target = "dishInfo.name")
    @Mapping(source = "price", target = "dishInfo.price")
    @Mapping(source = "description", target = "dishInfo.description")
    @Mapping(source = "urlImage", target = "dishInfo.urlImage")
    @Mapping(source = "category", target = "dishInfo.category")
    @Mapping(source = "restaurantId", target = "restaurantAssociation.restaurantId")
    Dish toDish(DishDto dishDto);

    @Mapping(source = "dishInfo.name", target = "name")
    @Mapping(source = "dishInfo.price", target = "price")
    @Mapping(source = "dishInfo.description", target = "description")
    @Mapping(source = "dishInfo.urlImage", target = "urlImage")
    @Mapping(source = "dishInfo.category", target = "category")
    @Mapping(source = "restaurantAssociation.restaurantId", target = "restaurantId")
    DishDto toDishDTO(Dish dish);

    @Mapping(target = "dishInfo.price", source = "price")
    @Mapping(target = "dishInfo.description", source = "description")
    Dish updateDishFromDTO(@MappingTarget Dish dish, UpdateDishDto updateDishDTO);

    @Mapping(target = "active", source = "isAvailable")
    Dish updateDishAvailability(@MappingTarget Dish dish, UpdateDishActive updateDishActive);

    List<DishDto> toDishDTOList(List<Dish> dishes);
}
