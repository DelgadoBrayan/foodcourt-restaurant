package com.menu.dish.infrastructure.input.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishActive;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.application.handler.DishHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/owner/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishHandler dishHandler;

    @PostMapping
    public ResponseEntity<Void> createDish(@Valid @RequestBody DishDto dishDto) {
        dishHandler.createDish(dishDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@PathVariable Long id, @Valid @RequestBody UpdateDishDto dishDto) {
        dishHandler.updateDish(id, dishDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<Void> updateDishAvailability(@PathVariable Long id, @RequestBody UpdateDishActive updateDishActive) {
        dishHandler.toggleDishAvailability(id, updateDishActive);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<DishDto>> listDishesByRestaurant(@PathVariable Long restaurantId, 
                                                                @RequestParam int page,
                                                                @RequestParam int size, 
                                                                @RequestParam(required = false) 
                                                                String category) {

        List<DishDto> dishes = dishHandler.listDishesByRestaurant(restaurantId, page, size, category);
        
        return ResponseEntity.status(HttpStatus.OK).body(dishes);
    }

    @GetMapping("/byIds")
    public ResponseEntity<List<DishDto>> getDishesByIds(@RequestParam List<Long> ids) {
        List<DishDto> dishes = dishHandler.getDishesByIds(ids);
        return ResponseEntity.status(HttpStatus.OK).body(dishes);
    }

}
