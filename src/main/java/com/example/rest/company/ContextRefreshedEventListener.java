package com.example.rest.company;

import com.example.rest.company.dao.repository.EmployeeRepository;
import com.example.rest.company.service.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ContextRefreshedEventListener {

    private final EmployeeRepository repository;

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent ctxStartEvt) {
        repository.saveAll(Arrays.asList(
                createEmployee("Ivan", "Facebook", "ivan@mail.com", 25),
                createEmployee("Ivan", "Google", "ivan2@mail.com", 20),
                createEmployee("Petr", "Facebook", "petr@mail.com", 30),
                createEmployee("Vasiliy", "Amazon", "vasia@mail.com", 45),
                createEmployee("Gregor", "Amazon", "gregor@mail.com", 23),
                createEmployee("Sergey", "Facebook", "sergey@mail.com", 35),
                createEmployee("Slava", "Amazon", "slava@mail.com", 24)
        ));
    }

    private Employee createEmployee(String name, String company, String email, Integer age) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setCompany(company);
        employee.setEmail(email);
        employee.setAge(age);
        return employee;
    }
}
