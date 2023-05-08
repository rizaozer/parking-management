package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
