package com.example.demo.employee.api;

import com.example.demo.db.entity.Employee;
import com.example.demo.db.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeeApiService {
    private EmployeeRepository repository;

    EmployeeApiService(EmployeeRepository repository) {
        this.repository = repository;
    }

    List<Employee> get() {
        return repository.findAll();
    }
}
