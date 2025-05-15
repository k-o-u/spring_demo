package com.example.demo.department;

import com.example.demo.db.entity.Department;
import com.example.demo.db.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository repository;

    DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    String insert(Department department) {
        repository.save(department);
        return "Success";
    }

    List<Department> getDepartments() {
        return repository.findAll();
    }
}
