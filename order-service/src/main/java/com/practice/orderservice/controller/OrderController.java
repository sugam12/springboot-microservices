package com.practice.orderservice.controller;

import com.practice.orderservice.entity.Order;
import com.practice.orderservice.dto.OrderDto;
import com.practice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /*public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }*/

    /*@PostMapping
    public ResponseEntity<Mono<Department>> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.addDepartment(department), CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<Department>> getDepartment() {
        return new ResponseEntity<>(departmentService.getDepartment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Department>> getDepartment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.addOrder(order), CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrder() {
        return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOrder(@PathVariable("id") Long id) {
        OrderDto orderById = orderService.getOrderById(id);

        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }
}
