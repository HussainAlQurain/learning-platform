package com.example.demo.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Lesson {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<LessonTranslation> lessonTranslations;

    private Integer orderIndex;

    @OneToMany(mappedBy = "lesson")
    private List<LessonVocabulary> lessonVocabularies;
}
