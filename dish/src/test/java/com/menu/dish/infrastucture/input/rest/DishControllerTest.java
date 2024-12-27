package com.menu.dish.infrastucture.input.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.handler.DishHandler;

 class DishControllerTest {

    @Mock
    private DishHandler dishHandler;

    @InjectMocks
    private DishController dishController;

    private MockMvc mockMvc;
    private DishDto dishDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(dishController).build();
        
        dishDto = new DishDto();
        dishDto.setName("Pasta");
        dishDto.setPrice(10000);
        dishDto.setDescription("Delicious pasta");
        dishDto.setUrlImage("http://example.com/image.png");
        dishDto.setCategory("Main Course");
        dishDto.setRestaurantId(1L);
    }

    @Test
     void testCreateDish() throws Exception {
        doNothing().when(dishHandler).createDish(any(DishDto.class));

        mockMvc.perform(post("/owner/dishes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Pasta\", \"price\": 10000, \"description\": \"Delicious pasta\", \"urlImage\": \"http://example.com/image.png\", \"category\": \"Main Course\", \"restaurantId\": 1}"))
                .andExpect(status().isCreated());

        verify(dishHandler, times(1)).createDish(any(DishDto.class));
    }
}
