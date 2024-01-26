package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.bussines.SalaryService;
import org.ibs.service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/max/departament{departamentId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "Get max summary employee")
    Employee maxSalaryEmployeeInDepartament(@PathVariable Long departamentId){
        return salaryService.maxSalaryEmployeeDepartament(departamentId)
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Departament or employees not found"));
    }

    @GetMapping("/salaryMoreThanBoss")
    @Operation(summary = "получить список сотрудников, чья месячная заработная плата непосредственно больше, чем у их руководителей")
    List<org.ibs.service.domains.entity.Employee> EmployeesSalaryMoreThanBoss(){
        return salaryService.salaryMoreThanBoss();
//        return new ArrayList<org.ibs.service.domains.entity.Employee>();
    }
}
