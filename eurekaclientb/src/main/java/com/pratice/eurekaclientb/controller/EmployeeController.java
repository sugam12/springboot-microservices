package com.pratice.eurekaclientb.controller;

import com.pratice.eurekaclientb.dto.EmployeeDto;
import com.pratice.eurekaclientb.entity.Employee;
import com.pratice.eurekaclientb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    ResponseEntity<EmployeeDto> employee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Employee>> employee() {
        return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> employee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    ResponseEntity<List<Employee>> employeeByDepartmentId(@PathVariable("departmentId") Long id) {

        return new ResponseEntity<>(employeeService.getEmployeeByDepartment(id), HttpStatus.OK);
    }
}
