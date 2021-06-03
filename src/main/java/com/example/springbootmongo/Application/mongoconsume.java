package com.example.springbootmongo.Application;

import com.example.springbootmongo.Application.mongodbapp.*;
import com.example.springbootmongo.Employee;
import com.example.springbootmongo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class mongoconsume {
    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping("/AllEmployees")
    public List<Employee> AllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/FindEmployee/{id}")
    public Optional<Employee> findEmploy(@PathVariable int id){
        return employeeRepository.findById(id);
    }

    @DeleteMapping("/DeleteEmploy/{id}")
    public Optional<Employee> deleteEmploy(@PathVariable int id){
        Optional<Employee> emplist=employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        return emplist;
    }
}

