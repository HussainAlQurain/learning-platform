package com.example.demo.backend.domain;

import jakarta.persistence.*;

@Entity
public class ResourceComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resource resource;

    private String title;

    @Enumerated(EnumType.STRING)
    private ComponentType componentType;

    @Lob
    private String instructions;

    @Lob
    private String content;

    private Integer orderIndex;

    private Integer estimatedMinutes;

    private Boolean mandatory;

    public enum ComponentType {
        DISCUSSION, QUIZ, VOCABULARY, WRITING, REFLECTION, ACTIVITY
    }
}
