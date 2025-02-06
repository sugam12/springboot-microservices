package com.pratice.eurekaclienta.dto;

import com.pratice.eurekaclienta.entity.Employee;
import lombok.Data;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.List;


@Data

public class DepartmentDto implements Serializable {

    private long id;

    private String name;

    private List<Employee> employeeList;

    public DepartmentDto(long id, String name, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.employeeList = employeeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
