package com.menu.dish.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.menu.dish.domain.api.IDishServicePort;
import com.menu.dish.domain.spi.IDishPersistencePort;
import com.menu.dish.domain.spi.IEmployeePersistencePort;
import com.menu.dish.domain.usecase.DishUseCase;
import com.menu.dish.infrastructure.out.jpa.adapter.DishJpaAdapter;
import com.menu.dish.infrastructure.out.jpa.adapter.EmployeeRepositoryAdapter;
import com.menu.dish.infrastructure.out.jpa.mapper.DishEntityMapper;
import com.menu.dish.infrastructure.out.jpa.mapper.EmployeeEntityMapper;
import com.menu.dish.infrastructure.out.jpa.repository.DishRepository;
import com.menu.dish.infrastructure.out.jpa.repository.EmployeeJpaRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final DishRepository dishRepository;
    private final DishEntityMapper dishEntityMapper;
    private final EmployeeJpaRepository employeeJpaRepository;
    private final EmployeeEntityMapper employeeEntityMapper;
    

    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishJpaAdapter(dishRepository, dishEntityMapper);
    }

    @Bean
    IDishServicePort dishServicePort(){
        return new DishUseCase(dishPersistencePort());
    }

    @Bean
    IEmployeePersistencePort employeePersistencePort() {
        return new EmployeeRepositoryAdapter(employeeJpaRepository, employeeEntityMapper);
    }

}


