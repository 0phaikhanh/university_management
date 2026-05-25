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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy điểm rèn luyện với ID: " + id));
    }

    @Override
    public BehavioralScore createScore(BehavioralScoreRequestDTO dto) {
        // Kiểm tra ràng buộc UNIQUE (student_id, semester_id)
        scoreRepository.findByStudentIdAndSemesterId(dto.getStudentId(), dto.getSemesterId())
                .ifPresent(s -> {
                    throw new RuntimeException("Điểm rèn luyện của sinh viên trong học kỳ này đã tồn tại!");
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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy điểm rèn luyện để cập nhật!"));

        existing.setStudentId(dto.getStudentId());
        existing.setSemesterId(dto.getSemesterId());
        existing.setTotalPoints(dto.getTotalPoints());
        existing.setClassification(dto.getClassification());

        return scoreRepository.save(existing);
    }

    @Override
    public void deleteScore(Long id) {
        BehavioralScore existing = scoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy điểm rèn luyện để xóa!"));
        scoreRepository.delete(existing);
    }
}
