package com.example.demo.backend.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class UserProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Resource resource;

    private Double completionPercentage;

    private Boolean completed;

    private Double score;

    private Instant completedAt;
}
