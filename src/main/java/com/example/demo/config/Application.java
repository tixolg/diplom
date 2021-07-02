package com.example.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.example.demo"})
@EntityScan("com.example.demo.model")
@EnableJpaRepositories("com.example.demo.datebase")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{
                Application.class
        }, args);
    }
}