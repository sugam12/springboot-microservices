package com.practice.inventoryservice.controller;

import com.practice.inventoryservice.dto.InventoryDto;
import com.practice.inventoryservice.entity.Inventory;
import com.practice.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    ResponseEntity<InventoryDto> addInventory(@RequestBody Inventory inventory) {
        return new ResponseEntity<>(inventoryService.addInventory(inventory), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Inventory>> inventory() {
        return new ResponseEntity<>(inventoryService.getInventory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Inventory> inventory(@PathVariable("id") Long id) {
        return new ResponseEntity<>(inventoryService.getInventory(id), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    ResponseEntity<List<Inventory>> inventoryByOrderId(@PathVariable("orderId") Long id) {
// Inventory will belong to department/section. Need to create that as well
        return new ResponseEntity<>(inventoryService.getInventoryByOrderId(id), HttpStatus.OK);
    }
}
