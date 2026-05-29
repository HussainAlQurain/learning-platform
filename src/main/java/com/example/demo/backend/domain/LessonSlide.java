package com.example.demo.backend.domain;

import jakarta.persistence.*;

@Entity
public class LessonSlide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;
    private Integer orderIndex;

    @Enumerated(EnumType.STRING)
    private SlideType type;

    @Lob
    private String content;

    public enum SlideType {
        TEXT, IMAGE, VIDEO, QUIZ, VOCABULARY,
    }
}
