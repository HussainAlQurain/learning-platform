package com.example.demo.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vocabulary {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "vocabulary", cascade = CascadeType.ALL)
    private List<VocabularyTranslation> vocabularyTranslations;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @OneToMany(mappedBy = "vocabulary")
    private List<LessonVocabulary> lessonVocabularies;
}
