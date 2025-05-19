package com.example.demo.employee.api;

import com.example.demo.db.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employee")
class EmployeeApiController {
    private EmployeeApiService service;

    EmployeeApiController(EmployeeApiService service) {
        this.service = service;
    }

    @GetMapping("/get")
    List<Employee> get() {
        return service.get();
    }
}
