package com.example.demo.employee;

import com.example.demo.db.entity.Employee;
import com.example.demo.db.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    Page<Employee> getAllEmployee(Pageable pageable) {
        Page<Employee> employeeList = employeeRepository.findAll(pageable);
        return employeeList;
    }

    List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }
}
