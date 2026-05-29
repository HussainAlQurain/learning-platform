package com.example.demo.backend.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String arabicTitle;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    private Stage stage;
    private String description;
    private String coverImageUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account author;
    private Integer estimatedMinutes;
    private Integer wordCount;
    private Boolean topRated = false;

    public enum ResourceType {
        BOOK, VIDEO, SONG, ARTICLE, STORY, COMIC
    }

    @OneToMany(mappedBy = "resource")
    private List<ResourceComponent> resourceComponents;
}


