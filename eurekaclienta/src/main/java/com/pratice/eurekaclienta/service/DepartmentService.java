package com.pratice.eurekaclienta.service;

import com.pratice.eurekaclienta.client.EmployeeClient;
import com.pratice.eurekaclienta.dto.DepartmentDto;
import com.pratice.eurekaclienta.entity.Department;
import com.pratice.eurekaclienta.entity.Employee;
import com.pratice.eurekaclienta.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    // private final Mapper<Department, DepartmentDto> departmentMapper;

    /*public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        //this.departmentMapper = mapper;
    }*/

    /* public Mono<Department> addDepartment(Department department) {
         Mono<Department> departmentEntity = departmentRepository.save(department);
         return departmentEntity;

     }
     public Flux<Department> getDepartment() {
         return departmentRepository.findAllDepartment();
     }

     public Mono<Department> getDepartmentById(Long id) {
         return departmentRepository.findByDepartmentId(id);
     }
     */
    @Transactional
    public Department addDepartment(Department department) {
        Department departmentEntity = departmentRepository.save(department);
        return departmentEntity;

    }

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Autowired
    private EmployeeClient employeeClient;

    @Transactional
    public DepartmentDto getDepartmentById(Long id) {
       /* Department optionalDepartment = departmentRepository.findById(id).ifPresentOrElse(department -> {
            department.setEmployeeList(employeeClient.findEmployeeByDepartment(department.getId()));
            return department;
        }, null);*/

        Department department = departmentRepository.findById(id).orElseThrow();
       List<Employee> employeeByDepartment = null;
        try {
            employeeByDepartment = employeeClient.findEmployeeByDepartment(department.getId());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName(), employeeByDepartment);
        return departmentDto;

    }
}
