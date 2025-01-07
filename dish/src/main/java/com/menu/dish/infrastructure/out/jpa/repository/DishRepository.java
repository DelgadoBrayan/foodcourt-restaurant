package com.menu.dish.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.dish.infrastructure.out.jpa.entity.DishEntity;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {
}
