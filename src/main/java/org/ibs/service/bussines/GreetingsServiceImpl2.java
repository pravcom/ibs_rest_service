package org.ibs.service.bussines;

import org.ibs.service.domains.entity.Employee;

import java.util.logging.Logger;

public class GreetingsServiceImpl2 implements GreetingsService {
    private Logger log;

    public GreetingsServiceImpl2(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee){
        log.info("Hello from test "+employee.getFirstName());
    }
}
