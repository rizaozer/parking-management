package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private long id;
    private String plateNumber;
    private String color;
    private String brand;
    @ManyToOne
    private Owner owner;
}
