package com.example.springbootmongo.Application;

import com.example.springbootmongo.config.*;
import com.example.springbootmongo.Employee;
import com.example.springbootmongo.Repository.EmployeeRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/*
@RestController
@RequestMapping("/Employee")

 */
@Service
public class mongodbapp{
    @Autowired
    public EmployeeRepository employeeRepository;

    @RabbitListener(queues = rabbitmqConfig.QUEUE)
    public void createEmployee( Employee emp){
        employeeRepository.save(emp);
        System.out.println("Kudos!!! Added Employee "+emp.getEmpName()+" Successfully");
        //return "Kudos!!! Added Employee "+emp.getEmpName()+" Successfully";
    }

/*
    @GetMapping("/AllEmployee")
    public List<Employee> Employees(){
        System.out.println(employeeRepository.findAll());
        return  employeeRepository.findAll();
    }
    @GetMapping("/FindEmployee/{id}")
    public Optional<Employee> findemp(@PathVariable int id){
        return employeeRepository.findById(id);
    }

 */
}