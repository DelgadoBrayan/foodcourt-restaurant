package com.menu.dish.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.dish.infrastructure.out.jpa.entity.EmployeeEntity;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
