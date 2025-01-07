package com.menu.dish.infrastructure.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.dish.application.dto.employee.EmployeeRequest;
import com.menu.dish.application.handler.EmployeeHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owner/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeHandler employeeHandler;

      @PostMapping
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        employeeHandler.savEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
