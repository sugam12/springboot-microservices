package com.practice.orderservice.dto;

import com.practice.orderservice.entity.Inventory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data

public class OrderDto implements Serializable {

    private long id;

    private String name;

    private List<Inventory> inventoryList;

    public OrderDto() {
    }

    public OrderDto(long id, String name, List<Inventory> inventoryList) {
        this.id = id;
        this.name = name;
        this.inventoryList = inventoryList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
