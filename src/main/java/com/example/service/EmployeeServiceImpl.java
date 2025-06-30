package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteById(Long id) {
        employeeRepo.deleteById(id);
        return "Deleted Successfully ID : " +id ;
    }



    public Employee updateEmployee(Long id, Employee updatedEmp) {
        return employeeRepo.findById(id).map(employee -> {
            employee.setName(updatedEmp.getName());
            return employeeRepo.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
