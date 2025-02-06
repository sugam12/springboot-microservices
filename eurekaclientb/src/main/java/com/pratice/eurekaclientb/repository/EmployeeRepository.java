package com.pratice.eurekaclientb.repository;

import com.pratice.eurekaclientb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   // Optional<Employee> findByIdAndDeletedFalse(Long id);

    List<Employee> findByDepartmentId(Long departmentId);
}
