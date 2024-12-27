package com.menu.dish.infrastucture.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.dish.infrastucture.out.jpa.entity.DishEntity;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
}
