package com.practice.orderservice.repository;

import com.practice.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

   /* @Query("SELECT * FROM department WHERE id = :id")
    Department findByDepartmentId(@Param("id") Long id);

    @Query("SELECT * FROM department")
    List<Department> findAllDepartment();*/
}
