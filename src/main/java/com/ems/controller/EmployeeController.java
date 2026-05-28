package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(
            @RequestBody Employee employee
    ) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(id, employee);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam String keyword
    ) {
        return employeeService.searchEmployees(keyword);
    }
}