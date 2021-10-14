package com.example.rest.company.service.api;

import com.example.rest.company.service.model.Employee;
import com.example.rest.company.service.model.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    Employee getById(Long id);

    Employee createEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployees();

    Page<Employee> getAllEmployees(int page, int size);
}
