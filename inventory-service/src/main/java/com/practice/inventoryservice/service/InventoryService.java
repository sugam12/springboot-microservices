package com.practice.inventoryservice.service;

import com.practice.inventoryservice.dto.InventoryDto;
import com.practice.inventoryservice.entity.Inventory;
import com.practice.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    /*public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
*/
    public InventoryDto addInventory(Inventory inventory) {
        //Employee newEmployee = new Employee(employee.getId(), employee.getDepartmentId(), employee.getName(), employee.getAge(), employee.getPosition());
        Inventory newInventory = inventoryRepository.save(inventory);
        InventoryDto inventoryDto = new InventoryDto(newInventory.getId(), newInventory.getDepartmentId(), newInventory.getName(), newInventory.getAge(),  newInventory.getPosition());
        return inventoryDto;
    }

    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).orElseThrow();
    }

    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> getInventoryByOrderId(Long departmentId) {
        List<Inventory> inventoryByDepartment = inventoryRepository.findByDepartmentId(departmentId);
        return !inventoryByDepartment.isEmpty() ? inventoryByDepartment : new ArrayList<>();
    }
}
