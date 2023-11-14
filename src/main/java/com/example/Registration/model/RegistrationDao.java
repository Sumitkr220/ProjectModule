package com.example.Registration.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegistrationDao {
    private Long id;
    private String userEmail;
    private String firstName;
    private String lastName;
    private String state;
    private String country;
    private String passwordHash;
    private String authId;
}
