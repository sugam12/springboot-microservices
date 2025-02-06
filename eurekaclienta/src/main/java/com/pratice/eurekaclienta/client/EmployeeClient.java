package com.pratice.eurekaclienta.client;

import com.pratice.eurekaclienta.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/employee/department/{departmentId}")
    List<Employee> findEmployeeByDepartment(@PathVariable("departmentId") Long departmentId);
}
