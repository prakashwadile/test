package com.example.service;

import com.example.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> findAll();
    public Employee save( Employee employee) ;
    public String deleteById( Long id);
    public Employee updateEmployee(Long id, Employee updatedEmp);

}
