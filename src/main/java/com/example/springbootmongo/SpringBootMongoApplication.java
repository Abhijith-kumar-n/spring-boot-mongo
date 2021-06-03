package com.example.springbootmongo;

import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringBootMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoApplication.class, args);
    }

}