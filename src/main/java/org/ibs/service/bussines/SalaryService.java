package org.ibs.service.bussines;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domains.DepartamentRepository;
import org.ibs.service.domains.EmployeeRepository;
import org.ibs.service.domains.entity.Departament;
import org.ibs.service.domains.entity.Employee;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SalaryService {
    @Autowired
    DepartamentRepository departamentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    public Optional<org.ibs.service.dto.Employee> maxSalaryEmployeeDepartament(Long departamentId){
        Optional<Departament> departamentOpt = departamentRepository.findById(departamentId);

        if(departamentOpt.isEmpty() || departamentOpt.get().getEmployees().isEmpty()){
            return Optional.empty();
        }

        Employee employee = departamentOpt.get().getEmployees().stream()
                .max((e1,e2) -> e1.getMonthSalary().compareTo(e2.getMonthSalary())).get();

        return Optional.of(mapper.toDto(employee));
    }

    public List<Employee> salaryMoreThanBoss(){
        List<Employee> employees = new ArrayList<>();

        Iterable<Employee> employeesAll = employeeRepository.findAll();

        for (Employee val:employeesAll){
            if (val.getBossId()==null) continue;

            Long employeeSalary = val.getMonthSalary();
            Long bossId = val.getBossId();
            Long bossSalary = employeeRepository.findById(bossId).get().getMonthSalary();

            if (employeeSalary>bossSalary) employees.add(val);
        }

        return employees;
    }
}
