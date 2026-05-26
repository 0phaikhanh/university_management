package com.example.university_management.modules.behavioral_score.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.behavioral_score.dto.BehavioralScoreRequestDTO;
import com.example.university_management.modules.behavioral_score.entity.BehavioralScore;
import com.example.university_management.modules.behavioral_score.repository.BehavioralScoreRepository;
import com.example.university_management.modules.behavioral_score.service.BehavioralScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BehavioralScoreServiceImpl implements BehavioralScoreService {

    private final BehavioralScoreRepository scoreRepository;

    public BehavioralScoreServiceImpl(BehavioralScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<BehavioralScore> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public BehavioralScore getScoreById(Long id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Behavioral score not found with ID: " + id));
    }

    @Override
    public BehavioralScore createScore(BehavioralScoreRequestDTO dto) {
        // Validate UNIQUE constraint (student_id, semester_id)
        scoreRepository.findByStudentIdAndSemesterId(dto.getStudentId(), dto.getSemesterId())
                .ifPresent(s -> {
                    throw new RuntimeException("Behavioral score for this student and semester already exists!");
                });

        BehavioralScore score = BehavioralScore.builder()
                .studentId(dto.getStudentId())
                .semesterId(dto.getSemesterId())
                .totalPoints(dto.getTotalPoints())
                .classification(dto.getClassification())
                .build();

        return scoreRepository.save(score);
    }

    @Override
    public BehavioralScore updateScore(Long id, BehavioralScoreRequestDTO dto) {
        BehavioralScore existing = scoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Behavioral score to update was not found!"));

        existing.setStudentId(dto.getStudentId());
        existing.setSemesterId(dto.getSemesterId());
        existing.setTotalPoints(dto.getTotalPoints());
        existing.setClassification(dto.getClassification());

        return scoreRepository.save(existing);
    }

    @Override
    public void deleteScore(Long id) {
        BehavioralScore existing = scoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Behavioral score to delete was not found!"));
        scoreRepository.delete(existing);
    }
}
