package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.bussines.BossService;
import org.ibs.service.bussines.SalaryService;
import org.ibs.service.domains.EmployeeRepository;
import org.ibs.service.domains.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("boss controller v2")
@RequestMapping("/v2/boss")
@Slf4j
public class BossController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/bossId{bossId}")
    @Operation(summary = "получить список непосредственных подчиненных руководителя")
    public List<Employee> getEmployeesOfBoss(@RequestParam(required = true) @PathVariable Long bossId){
        return repository.findAllByBossId(bossId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "получить непосредственного руководителя сотрудника")
    public Optional<Employee> getBossOfEmployee(@PathVariable Long id){
        log.info("-------------------------------------------------------");
        log.info(id.toString());
        log.info("-------------------------------------------------------");
        return repository.findById(repository.findById(id).get().getBossId());
    }
}
