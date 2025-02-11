package com.practice.inventoryservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class BaseEntity {
    private boolean deleted;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
