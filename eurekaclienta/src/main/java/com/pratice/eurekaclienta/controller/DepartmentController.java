package com.pratice.eurekaclienta.controller;

import com.pratice.eurekaclienta.dto.DepartmentDto;
import com.pratice.eurekaclienta.entity.Department;
import com.pratice.eurekaclienta.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /*public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }*/

    /*@PostMapping
    public ResponseEntity<Mono<Department>> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.addDepartment(department), CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<Department>> getDepartment() {
        return new ResponseEntity<>(departmentService.getDepartment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Department>> getDepartment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.addDepartment(department), CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartment() {
        return new ResponseEntity<>(departmentService.getDepartment(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getDepartment(@PathVariable("id") Long id) {
        DepartmentDto departmentById = departmentService.getDepartmentById(id);

        return new ResponseEntity<>(departmentById, HttpStatus.OK);
    }
}
