package com.example.rest.company.service.impl;


import com.example.rest.company.dao.repository.EmployeeRepository;
import com.example.rest.company.service.api.EmployeeService;
import com.example.rest.company.service.model.Employee;
import com.example.rest.company.service.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        repository.findByName(employeeDto.getName())
                .ifPresent(user -> {
                    throw new RuntimeException(String.format("Employee with name %s already exist", user.getName()));
                });
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setCompany(employeeDto.getCompany());
        employee.setEmail(employeeDto.getEmail());
        return repository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Employee with id %s not found", id)));
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("company", "name")));
    }
}
