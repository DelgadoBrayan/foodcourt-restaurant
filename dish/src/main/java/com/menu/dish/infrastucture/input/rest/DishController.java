package com.menu.dish.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.dish.application.dto.DishDto;
import com.menu.dish.application.dto.UpdateDishDto;
import com.menu.dish.application.handler.DishHandler;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/owner/dishes")
@AllArgsConstructor
public class DishController {
    private DishHandler dishHandler;

    @PostMapping
    public ResponseEntity<Void> createDish(@Valid @RequestBody DishDto dishDto) {
        dishHandler.createDish(dishDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@PathVariable Long id, @Valid @RequestBody UpdateDishDto dishDto) {
        dishHandler.updateDish(id,dishDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
