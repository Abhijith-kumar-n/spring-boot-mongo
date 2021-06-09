package com.example.springbootmongo.Application;

import com.example.springbootmongo.config.*;
import com.example.springbootmongo.Employee;
import com.example.springbootmongo.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger= LoggerFactory.getLogger(mongodbapp.class);
    @RabbitListener(queues = rabbitmqConfig.QUEUE)
    public void createEmployee( Employee emp){
        employeeRepository.save(emp);
        logger.debug(">> Received Employee Details from Rabbit");
        System.out.println("Kudos!!! Added Employee "+emp.getEmpName()+" Successfully");
    }

}