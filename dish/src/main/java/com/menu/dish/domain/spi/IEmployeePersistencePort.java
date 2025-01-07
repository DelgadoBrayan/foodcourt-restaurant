package com.menu.dish.domain.spi;

import com.menu.dish.domain.model.employee.Employee;

public interface IEmployeePersistencePort {

    Employee saveEmployee(Employee employee);
}
