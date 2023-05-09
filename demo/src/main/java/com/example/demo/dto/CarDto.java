package com.example.demo.dto;

import com.example.demo.model.Owner;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDto {

    private long id;
    private String plateNumber;
    private String color;
    private String brand;
    private Owner owner;
}
