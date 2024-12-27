package com.menu.dish.infrastucture.out.jpa.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.menu.dish.domain.model.Dish;
import com.menu.dish.domain.model.DishInfo;
import com.menu.dish.domain.model.RestaurantAssociation;
import com.menu.dish.infrastucture.out.jpa.entity.DishEntity;
import com.menu.dish.infrastucture.out.jpa.mapper.DishEntityMapper;
import com.menu.dish.infrastucture.out.jpa.repository.DishRepository;

 class DishJpaAdapterTest {

    @Mock
    private DishRepository dishRepository;

    private DishEntityMapper dishEntityMapper = DishEntityMapper.INSTANCE;

    @InjectMocks
    private DishJpaAdapter dishJpaAdapter;

    private Dish dish;
    private DishEntity dishEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dishEntity = new DishEntity();
        dishEntity.setId(1L);
        dishEntity.setName("Pasta");
        dishEntity.setPrice(10000);
        dishEntity.setDescription("Delicious pasta");
        dishEntity.setUrlImage("http://example.com/image.png");
        dishEntity.setCategory("Main Course");
        dishEntity.setRestaurantId(1L);
        dishEntity.setActive(true);

        dish = new Dish(1L, new DishInfo("Pasta",
                                            10000, 
                                            "Delicious pasta", 
                                            "http://example.com/image.png", 
                                            "Main Course"), 
                                            new RestaurantAssociation(1L), 
                                            true);
    }


    @Test
     void testFindDishById() {
        when(dishRepository.findById(1L)).thenReturn(Optional.of(dishEntity));
        when(dishEntityMapper.toModel(dishEntity)).thenReturn(dish);

        Dish foundDish = dishJpaAdapter.findDishById(1L);

        assertNotNull(foundDish);
        verify(dishRepository, times(1)).findById(1L);
    }
}
