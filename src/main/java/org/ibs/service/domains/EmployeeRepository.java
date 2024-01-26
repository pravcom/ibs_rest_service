package org.ibs.service.domains;

import org.ibs.service.domains.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByBossId(Long bossId);
}
