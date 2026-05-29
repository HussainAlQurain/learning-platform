package com.example.demo.backend.domain;

import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resource resource;

    public enum ActivityType {
        FLASHCARD, MULTIPLE_CHOICE, MATCHING, LISTENING, TYPING, QUIZ
    }
}
