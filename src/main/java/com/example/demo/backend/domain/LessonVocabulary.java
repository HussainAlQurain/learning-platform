package com.example.demo.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonVocabulary {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vocabulary_id")
    private Vocabulary vocabulary;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    private Integer orderIndex;
}
