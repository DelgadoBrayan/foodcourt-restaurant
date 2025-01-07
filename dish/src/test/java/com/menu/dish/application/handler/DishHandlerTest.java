package com.menu.dish.application.handler;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.mapper.DishMapper;
import com.menu.dish.domain.model.Dish;
import com.menu.dish.domain.usecase.DishUseCase;

 class DishHandlerTest {

    @Mock
    private DishUseCase createDishUseCase;

    @InjectMocks
    private DishHandler dishHandler;

    private DishDto dishDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dishDto = new DishDto();
        dishDto.setName("Pasta");
        dishDto.setPrice(10.000);
        dishDto.setDescription("Delicious pasta");
        dishDto.setUrlImage("http://example.com/image.png");
        dishDto.setCategory("Main Course");
        dishDto.setRestaurantId(1L);
    }

    @Test
    void testCreateDish() {
        dishHandler.createDish(dishDto);

        Dish dish = DishMapper.INSTANCE.toDish(dishDto);
        verify(createDishUseCase, times(1)).saveDish(dish);
    }
}
