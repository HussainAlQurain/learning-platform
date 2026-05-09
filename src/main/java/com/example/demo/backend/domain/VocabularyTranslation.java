package com.example.demo.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VocabularyTranslation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vocabulary_id")
    private Vocabulary vocabulary;

    private String languageCode;
    private String word;
    private String translation;
    private String exampleSentence;
    private String partOfSpeech;
    private String ipaTranscription;

}
