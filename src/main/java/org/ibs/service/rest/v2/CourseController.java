package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domains.CourseRepository;
import org.ibs.service.domains.entity.Course;
import org.ibs.service.domains.entity.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController("course controller v2")
@RequestMapping("/v2/courses")
@Slf4j
public class CourseController {
    @Autowired
    CourseRepository repository;

    @GetMapping
    Iterable<Course> getAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "addCourse", summary = "adds new course")
    Course newDepartament(Course course){
        log.info("----------------------------------------------");
        if(course.getId() != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Found ID. Use empty ID for create");

        return repository.save(course);

    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id){
        repository.deleteById(id);
    }
}
