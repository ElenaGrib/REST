package com.example.rest.company.service.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeDto {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String company;

    private String email;

    private Integer age;
}
