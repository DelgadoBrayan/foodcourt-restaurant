package com.menu.dish.application.handler;

import org.springframework.stereotype.Service;

import com.menu.dish.application.dto.employee.EmployeeRequest;
import com.menu.dish.application.mapper.EmployeeMapper;
import com.menu.dish.domain.api.IEmployeeServicePort;
import com.menu.dish.domain.model.employee.Employee;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeHandler {
    private final IEmployeeServicePort employeeServicePort;

    public EmployeeRequest savEmployee(EmployeeRequest dto){
        Employee employee = EmployeeMapper.INSTANCE.toEntity(dto);
        Employee savEmployee = employeeServicePort.saveEmployee(employee);
        return EmployeeMapper.INSTANCE.toDto(savEmployee);
    }
}
