package com.menu.dish.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.dish.infrastructure.out.jpa.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {
    Page<DishEntity> findByRestaurantId(Long restaurantId, Pageable pageable); 
    Page<DishEntity> findByRestaurantIdAndCategory(Long restaurantId, String category, Pageable pageable);
}
