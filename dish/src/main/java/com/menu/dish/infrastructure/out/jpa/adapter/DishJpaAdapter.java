package com.menu.dish.infrastructure.out.jpa.adapter;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.menu.dish.domain.model.dish.Dish;
import com.menu.dish.domain.spi.IDishPersistencePort;
import com.menu.dish.infrastructure.out.jpa.entity.DishEntity;
import com.menu.dish.infrastructure.out.jpa.mapper.DishEntityMapper;
import com.menu.dish.infrastructure.out.jpa.repository.DishRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @Override
    public void toggleDishAvailability(Long id, boolean isAvailable) {
        dishRepository.findById(id).ifPresent(dishEntity -> {
            dishEntity.setActive(isAvailable);
            dishRepository.save(dishEntity);
        });
    }

    @Override
    public List<Dish> listDishesByRestaurant(Long restaurantId, int page, int size, String category) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<DishEntity> dishEntities;
        if (category != null && !category.isEmpty()) {
            dishEntities = dishRepository.findByRestaurantIdAndCategory(restaurantId, category, pageable);
        } else {
            dishEntities = dishRepository.findByRestaurantId(restaurantId, pageable);
        }
        return dishEntities.stream().map(dishEntityMapper::toModel).toList();
    }

    @Override
    public List<Dish> findDishesByIds(List<Long> ids) {
        List<DishEntity> dishEntities = dishRepository.findAllById(ids); // JpaRepository ya proporciona este método
        return dishEntities.stream()
                .map(dishEntityMapper::toModel) // Mapea las entidades a modelos
                .toList();
    }

}
