package com.practice.gateway.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class OrderDto implements Serializable {

    private long id;

    private String name;


    public OrderDto() {
    }

    public OrderDto(long id, String name) {
        this.id = id;
        this.name = name;
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

}
