package com.practice.orderservice.service;

import com.practice.orderservice.client.InventoryClient;
import com.practice.orderservice.dto.OrderDto;
import com.practice.orderservice.entity.Order;
import com.practice.orderservice.entity.Inventory;
import com.practice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
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
    public Order addOrder(Order order) {
        Order orderEntity = orderRepository.save(order);
        return orderEntity;

    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    @Autowired
    private InventoryClient inventoryClient;

    @Transactional
    public OrderDto getOrderById(Long id) {
       /* Department optionalDepartment = departmentRepository.findById(id).ifPresentOrElse(department -> {
            department.setEmployeeList(employeeClient.findEmployeeByDepartment(department.getId()));
            return department;
        }, null);*/

        Order order = orderRepository.findById(id).orElseThrow();
       List<Inventory> inventoryByDepartment = null;
        try {
            inventoryByDepartment = inventoryClient.findEmployeeByDepartment(order.getId());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        OrderDto orderDto = new OrderDto(order.getId(), order.getName(), inventoryByDepartment);
        return orderDto;

    }
}
