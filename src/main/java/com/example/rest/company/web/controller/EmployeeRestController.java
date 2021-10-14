package com.example.rest.company.web.controller;

import com.example.rest.company.service.api.EmployeeService;
import com.example.rest.company.service.model.Employee;
import com.example.rest.company.service.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeDto dto) {
        Employee employee = employeeService.createEmployee(dto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeDto dto) {
        //TODO update employee
        Employee employee = new Employee();
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        //TODO delete employee by id
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

//        @GetMapping("/list")
//        public Page<Employee> getAllEmployee ( @RequestParam("page") int page,
//        @RequestParam("size") int size){
//            return employeeService.getAllEmployees(page, size);
//        }
    }
