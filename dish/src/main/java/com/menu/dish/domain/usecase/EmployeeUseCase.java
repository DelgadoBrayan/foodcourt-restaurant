package com.menu.dish.domain.usecase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.menu.dish.domain.api.IEmployeeServicePort;
import com.menu.dish.domain.model.employee.ContactInfo;
import com.menu.dish.domain.model.employee.Employee;
import com.menu.dish.domain.spi.IEmployeePersistencePort;
import com.menu.dish.infrastructure.exception.InvalidEmployeeException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeUseCase implements IEmployeeServicePort{

    private final IEmployeePersistencePort employeePersistencePort;

 @Override
public Employee saveEmployee(Employee employee) {

    validateEmployeeFields(employee);

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(employee.getPassword());
    employee.setPassword(encodedPassword);

    // Guardar el empleado
    return employeePersistencePort.saveEmployee(employee);
}


private void validateEmployeeFields(Employee employee) {
    ContactInfo contactInfo = employee.getContactInfo();
    if (isNullOrEmpty(employee.getLastName())) {
        throw new InvalidEmployeeException("El apellido del empleado no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(employee.getLastName())) {
        throw new InvalidEmployeeException("El nombre del empleado no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getDocumentId())) {
        throw new InvalidEmployeeException("El documento de identidad no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getPhone()) || !contactInfo.getPhone().matches("\\+?\\d{1,13}")) {
        throw new InvalidEmployeeException("El celular debe ser numérico, con un máximo de 13 caracteres, y puede incluir '+'");
    }
    if (isNullOrEmpty(contactInfo.getEmail()) || !contactInfo.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
        throw new InvalidEmployeeException("El correo debe tener un formato válido");
    }
    if (isNullOrEmpty(employee.getPassword())) {
        throw new InvalidEmployeeException("La contraseña no debe estar vacía o nula");
    }
}

private boolean isNullOrEmpty(String value) {
    return value == null || value.trim().isEmpty();
}
  
}
