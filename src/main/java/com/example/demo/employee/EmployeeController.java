package com.example.demo.employee;

import com.example.demo.db.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/display")
    public String display(
            Model model,
            @PageableDefault(size = 3) Pageable pageable
    ) {
        Page<Employee> employees = employeeService.getAllEmployee(pageable);
        model.addAttribute("employees", employees.getContent());
        model.addAttribute("page", employees);
        return "employee/displayemployee";
    }

    @GetMapping("/display/all")
    public String displayAll(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee/displayallemployee";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @PathVariable("id") int id
    ) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee/detailemployee";
    }
}
