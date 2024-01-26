package org.ibs.service.bussines;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domains.entity.Employee;

import java.util.logging.Logger;
public class GreetingsServiceImpl implements GreetingsService {
    private Logger log;

    public GreetingsServiceImpl(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee){
        log.info("Hello "+employee.getFirstName());
    }
}
