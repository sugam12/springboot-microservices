package com.practice.orderservice.client;

import com.practice.orderservice.entity.Order;
import com.practice.orderservice.entity.Inventory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface InventoryClient {

    @GetExchange("/inventory/order/{orderId}")
    List<Inventory> findInventoryByDepartmentId(@PathVariable("orderId") Long orderId);

    List<Inventory> findInventoryByDepartmentId(Order order);
}
