package com.menu.dish.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menu.dish.domain.model.employee.Employee;
import com.menu.dish.infrastructure.out.jpa.entity.EmployeeEntity;

@Mapper(componentModel ="spring")
public interface EmployeeEntityMapper {
    EmployeeEntityMapper INSTANCE = Mappers.getMapper(EmployeeEntityMapper.class);

    @Mapping(source = "employee.contactInfo.documentId", target = "documentId")
    @Mapping(source = "employee.contactInfo.phone", target = "phone")
    @Mapping(source = "employee.contactInfo.email", target = "email")
    EmployeeEntity toEntity(Employee employee);

    @Mapping(source = "entity.documentId", target = "contactInfo.documentId")
    @Mapping(source = "entity.phone", target = "contactInfo.phone")
    @Mapping(source = "entity.email", target = "contactInfo.email")
    Employee toDomain(EmployeeEntity entity);
}
