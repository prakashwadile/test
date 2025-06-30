package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allemployees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "Deleted Successfully ID : " +id ;
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee
            updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }


}
