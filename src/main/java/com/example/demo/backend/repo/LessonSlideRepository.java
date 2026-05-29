package com.example.demo.backend.repo;

import com.example.demo.backend.domain.LessonSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonSlideRepository extends JpaRepository<LessonSlide, Long> {
    LessonSlide findByLessonId(Long lessonId);
}
