package com.example.rest.company.dao.repository;

import com.example.rest.company.service.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.Set;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Optional<Employee> findByName(String name);

    long countAllByCompanyIn(Set<String> company);
}
