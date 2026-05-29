package com.example.demo.backend.domain;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Lob
    private String questionText;

    @Lob
    private String explanation;

    private Integer orderIndex;

    public enum QuestionType {
        MULTIPLE_CHOICE, TRUE_FALSE, SHORT_ANSWER,
    }
}
