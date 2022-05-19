package com.seiton.familybudget;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@OpenAPIDefinition
public class FamilyBudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyBudgetApplication.class, args);
    }



}
