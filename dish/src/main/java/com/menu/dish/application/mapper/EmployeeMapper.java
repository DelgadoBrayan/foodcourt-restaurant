package com.menu.dish.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menu.dish.application.dto.employee.EmployeeRequest;
import com.menu.dish.domain.model.employee.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "dto.documentId", target = "contactInfo.documentId")
    @Mapping(source = "dto.phone", target = "contactInfo.phone")
    @Mapping(source = "dto.email", target = "contactInfo.email")
    Employee toEntity(EmployeeRequest dto);

    @Mapping(source = "employee.contactInfo.documentId", target = "documentId")
    @Mapping(source = "employee.contactInfo.phone", target = "phone")
    @Mapping(source = "employee.contactInfo.email", target = "email")
    EmployeeRequest toDto(Employee employee);
}
