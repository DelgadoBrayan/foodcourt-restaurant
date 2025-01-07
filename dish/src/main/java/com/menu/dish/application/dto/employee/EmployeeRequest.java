package com.menu.dish.application.dto.employee;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String id;
    private String fistName;
    private String lastName;
    private Long idRol;
    private String password;
    private String documentId;
    private String phone;
    private String email;
}
