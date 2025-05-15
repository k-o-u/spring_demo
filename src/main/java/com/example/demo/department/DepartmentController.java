package com.example.demo.department;

import com.example.demo.db.entity.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private DepartmentService service;

    DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    String insert(@RequestBody InsertDepRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        return service.insert(department);
    }

    @GetMapping("/get")
    List<Department> get() {
        return service.getDepartments();
    }
}
