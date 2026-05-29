package com.example.demo.backend.domain;

import jakarta.persistence.*;

@Entity
public class ResourceVocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Vocabulary vocabulary;

    @ManyToOne
    private Resource resource;
}
