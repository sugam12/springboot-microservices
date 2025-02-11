package com.practice.inventoryservice.repository;

import com.practice.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
   // Optional<Employee> findByIdAndDeletedFalse(Long id);

    List<Inventory> findByDepartmentId(Long departmentId);
}
