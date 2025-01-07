package com.menu.dish.infrastructure.out.jpa.adapter;

import com.menu.dish.domain.model.employee.Employee;
import com.menu.dish.domain.spi.IEmployeePersistencePort;
import com.menu.dish.infrastructure.out.jpa.entity.EmployeeEntity;
import com.menu.dish.infrastructure.out.jpa.mapper.EmployeeEntityMapper;
import com.menu.dish.infrastructure.out.jpa.repository.EmployeeJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeRepositoryAdapter implements IEmployeePersistencePort {

    private final EmployeeJpaRepository employeeJpa;
    private final EmployeeEntityMapper employeeMapper;
    @Override
    public Employee saveEmployee(Employee employee) {

        EmployeeEntity entity = employeeMapper.toEntity(employee);
        EmployeeEntity saveEmployeeEntity = employeeJpa.save(entity);
        
        return employeeMapper.toDomain(saveEmployeeEntity);
    }
    
}
