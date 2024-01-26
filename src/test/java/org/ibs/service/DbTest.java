package org.ibs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.ibs.service.domains.EmployeeRepository;
import org.ibs.service.domains.entity.Course;
import org.ibs.service.domains.entity.Departament;
import org.ibs.service.domains.entity.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

//import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@ActiveProfiles("test")
public class DbTest {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        Departament departament = new Departament();
        departament.setId(null);
        departament.setName("IT");

        Course course = new Course(null, "REST service");

        Employee employee = new Employee();
        employee.setId(null);
        employee.setBirthday(LocalDate.now());
        employee.setFirstName("A");
        employee.setLastName("B");
        employee.setMonthSalary(100L);
        employee.setDepartament(departament);
        employee.setCourses(List.of(course));

        entityManager.persist(departament);
        entityManager.persist(course);
        entityManager.persist(employee);
    }

    @Test
    public void test() {
//        setup();

        Assert.assertEquals(1, entityManager.createQuery("From Departament").getResultList().size());

        Employee employee = entityManager.createQuery("FROM Employee", Employee.class)
                .setMaxResults(1)
                .getResultList()
                .get(0);

        Assert.assertEquals("REST service", employee.getCourses().get(0).getName());


    }

    @Test
    public void test2() {
//        setup();
//        Employee employee = employeeRepository.findByFirstName("a").get();
//        Assert.assertEquals("REST service", employee.getCourses().get(0).getName());
    }
}
