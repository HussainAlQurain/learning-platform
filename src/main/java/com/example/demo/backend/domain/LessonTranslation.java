package com.example.demo.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LessonTranslation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private String languageCode;
    private String title;
    private String description;
    private String objective;
    @Column(columnDefinition = "TEXT")
    private String content;

}
