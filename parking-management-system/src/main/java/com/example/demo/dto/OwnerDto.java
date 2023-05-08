package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OwnerDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
