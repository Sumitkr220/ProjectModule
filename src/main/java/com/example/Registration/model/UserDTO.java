package com.example.Registration.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
@Entity
public class UserDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    private String userEmail;
    private String firstName;
    private String lastName;
    private String state;
    private String country;
    private String passwordHash;
    private String authId;
}
