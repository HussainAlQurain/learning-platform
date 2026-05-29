package com.example.demo.backend.service;

import com.example.demo.backend.domain.Stage;
import com.example.demo.backend.repo.StageRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PreAuthorize("isAuthenticated()")
public class StageService {
    private final StageRepository stageRepository;
    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> findAllStages() {
        return stageRepository.findAll();
    }

    public void saveStage(Stage stage) {
        stageRepository.save(stage);
    }
    public void deleteStage(Stage stage) {
        stageRepository.delete(stage);
    }
    public Stage findStageById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

}
 