package com.example.demo.backend.service;

import com.example.demo.backend.domain.Lesson;
import com.example.demo.backend.repo.LessonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PreAuthorize("isAuthenticated()")
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void saveLesson(Lesson lesson) {
        this.lessonRepository.save(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        this.lessonRepository.delete(lesson);
    }

    public Lesson findLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    public Page<Lesson> findByStageId(Pageable pageable, Long stageId) {
        return lessonRepository.findAllByStageId(pageable, stageId);
    }
}
