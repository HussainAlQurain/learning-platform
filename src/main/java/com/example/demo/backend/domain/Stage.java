package com.example.demo.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Stage {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String title;
    private String levelEquivalent;
    private Integer orderIndex;
    @OneToMany(mappedBy = "stage")
    private List<Lesson> lessons;
    @OneToMany(mappedBy = "stage")
    private List<Vocabulary> vocabulary;
}
