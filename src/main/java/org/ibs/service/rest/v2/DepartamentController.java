package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domains.DepartamentRepository;
import org.ibs.service.domains.entity.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController("dep controller v2")
@RequestMapping("/v2/departament")
@Slf4j
public class DepartamentController {
    @Autowired
    DepartamentRepository repository;

    @GetMapping
    Iterable<Departament> getAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "addDepartament", summary = "adds new departament")
    Departament newDepartament(Departament departament){
        log.info("----------------------------------------------");
        if(departament.getId() != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Found ID. Use empty ID for create");

        return repository.save(departament);

    }

    @DeleteMapping("/{id}")
    void deleteDepartament(@PathVariable Long id){
        repository.deleteById(id);
    }
}
