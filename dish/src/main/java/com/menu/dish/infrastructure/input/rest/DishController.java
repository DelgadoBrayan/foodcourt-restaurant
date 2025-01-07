package com.menu.dish.infrastructure.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.menu.dish.application.dto.DishDto;
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


}
