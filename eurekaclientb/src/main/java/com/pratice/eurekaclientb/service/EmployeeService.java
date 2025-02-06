package com.pratice.eurekaclientb.service;

import com.pratice.eurekaclientb.dto.EmployeeDto;
import com.pratice.eurekaclientb.entity.Employee;
import com.pratice.eurekaclientb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /*public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
*/
    public EmployeeDto addEmployee(Employee employee) {
        //Employee newEmployee = new Employee(employee.getId(), employee.getDepartmentId(), employee.getName(), employee.getAge(), employee.getPosition());
        Employee newEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = new EmployeeDto(newEmployee.getId(), newEmployee.getDepartmentId(),newEmployee.getName(), newEmployee.getAge(),  newEmployee.getPosition());
        return employeeDto;
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByDepartment(Long departmentId) {
        List<Employee> employeeByDepartment = employeeRepository.findByDepartmentId(departmentId);
        return !employeeByDepartment.isEmpty() ? employeeByDepartment : new ArrayList<>();
    }
}
