package org.ibs.service.confing;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.bussines.GreetingsService;
import org.ibs.service.bussines.GreetingsServiceImpl;
import org.ibs.service.bussines.GreetingsServiceImpl2;
import org.ibs.service.domains.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.logging.Logger;

@Configuration
public class GreetingsServiceConfig {
    Logger log = Logger.getAnonymousLogger();
    @Bean
    @Profile("!test")
    GreetingsService getGSImpl(){
        return new GreetingsServiceImpl(log);
    }

    @Bean
    @Profile("test")
    GreetingsService getGSImpl2(){
        return new GreetingsServiceImpl2(log);
    }

    @Bean
    Employee makeDefaultEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("Andrey");
        return employee;
    }

}
