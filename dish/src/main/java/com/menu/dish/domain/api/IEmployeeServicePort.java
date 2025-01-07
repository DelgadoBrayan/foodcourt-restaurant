package com.menu.dish.domain.api;

import com.menu.dish.domain.model.employee.Employee;

public interface IEmployeeServicePort {
    Employee saveEmployee(Employee employee);
}
