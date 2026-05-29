package com.example.demo.backend.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class UserVocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vocabulary vocabulary;
    @Enumerated(EnumType.STRING)
    private VocabularyStatus status;

    private Double masteryScore;

    private Instant learnedAt;

    private Instant lastReviewedAt;

    private Integer reviewCount;

    public enum VocabularyStatus {
        NEW, LEARNING, REVIEWING, MASTERED
    }
}
