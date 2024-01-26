package org.ibs.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPIDefinition
@RestController
@EnableJpaRepositories
public class IbsRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbsRestApplication.class, args);
    }
    @RequestMapping("/")
    String text(){
        return "Hello";
    }

}
