package com.example.demo.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String passwordHash;
    private String username;
    private String role;
}
