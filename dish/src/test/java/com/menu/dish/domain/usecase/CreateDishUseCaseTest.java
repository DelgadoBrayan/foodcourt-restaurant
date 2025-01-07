package com.menu.dish.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.menu.dish.domain.model.dish.Dish;
import com.menu.dish.domain.model.dish.DishInfo;
import com.menu.dish.domain.model.dish.RestaurantAssociation;
import com.menu.dish.domain.spi.IDishPersistencePort;

 class CreateDishUseCaseTest {

    @Mock
    private IDishPersistencePort dishPersistencePort;

    @InjectMocks
    private DishUseCase createDishUseCase;

    private Dish dish;
    private DishInfo dishInfo;
    private RestaurantAssociation restaurantAssociation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dishInfo = new DishInfo("Pasta", 10.000, "Delicious pasta", "http://example.com/image.png", "Main Course");
        restaurantAssociation = new RestaurantAssociation(1L);
        dish = new Dish(1L, dishInfo, restaurantAssociation, true);
    }

    @Test
     void testExecute_InvalidPrice() {
        dish.getDishInfo().setPrice(0.0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createDishUseCase.saveDish(dish);
        });

        assertEquals("Price must be greater than 0", exception.getMessage());
        verify(dishPersistencePort, never()).saveDish(any(Dish.class));
    }

    @Test
     void testExecute_NullRestaurantId() {
        dish.getRestaurantAssociation().setRestaurantId(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createDishUseCase.saveDish(dish);
        });

        assertEquals("Restaurant ID cannot be null", exception.getMessage());
        verify(dishPersistencePort, never()).saveDish(any(Dish.class));
    }

    @Test
     void testExecute_Success() {
        createDishUseCase.saveDish(dish);

        assertTrue(dish.isActive());
        verify(dishPersistencePort, times(1)).saveDish(dish);
    }
}

