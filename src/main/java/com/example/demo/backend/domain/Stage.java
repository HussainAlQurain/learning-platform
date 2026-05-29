package com.example.demo.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Name is required")
    private String name;
    private String title;
    @Pattern(regexp = "^[\\u0600-\\u06FF\\s]*$", message = "Only Arabic characters are allowed")
    private String arabicTitle;
    private String levelEquivalent;
    private Integer orderIndex;
    @OneToMany(mappedBy = "stage")
    private List<Lesson> lessons;
    @OneToMany(mappedBy = "stage")
    private List<Vocabulary> vocabulary;

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", arabicTitle='" + arabicTitle + '\'' +
                ", levelEquivalent='" + levelEquivalent + '\'' +
                ", orderIndex=" + orderIndex +
                '}';
    }
}
