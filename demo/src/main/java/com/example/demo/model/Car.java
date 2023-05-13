package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private String plateNumber;
    private String color;
    private String brand;
    @ManyToOne
    private Owner owner;
}
