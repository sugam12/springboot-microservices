package com.practice.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.io.Serializable;



@Entity
@Table(name = "TBL_EMPLOYEE")
@AllArgsConstructor
public class Inventory extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DEPART_ID")
    private Long departmentId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "POSITION")
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
