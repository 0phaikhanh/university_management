package com.example.university_management.modules.trainingprogram.service.impl;

import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import com.example.university_management.modules.trainingprogram.repository.TrainingProgramRepository;
import com.example.university_management.modules.trainingprogram.service.TrainingProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;

    public TrainingProgramServiceImpl(TrainingProgramRepository trainingProgramRepository) {
        this.trainingProgramRepository = trainingProgramRepository;
    }

    @Override
    public List<TrainingProgram> getAllPrograms() {
        return trainingProgramRepository.findAll();
    }

    @Override
    public TrainingProgram getProgramById(String id) {
        return trainingProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chương trình đào tạo với ID: " + id));
    }

    @Override
    public TrainingProgram createProgram(TrainingProgramRequestDTO dto) {
        if (trainingProgramRepository.existsById(dto.getProgramId())) {
            throw new RuntimeException("Mã chương trình đào tạo đã tồn tại!");
        }

        // TODO: có thể check Major tồn tại ở đây

        TrainingProgram program = TrainingProgram.builder()
                .programId(dto.getProgramId())
                .majorId(dto.getMajorId()) // Lưu String
                .programName(dto.getProgramName())
                .requiredCreditsToGraduate(dto.getRequiredCreditsToGraduate())
                .build();

        return trainingProgramRepository.save(program);
    }

    @Override
    public TrainingProgram updateProgram(String id, TrainingProgramRequestDTO dto) {
        TrainingProgram existing = trainingProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chương trình đào tạo để cập nhật!"));

        existing.setMajorId(dto.getMajorId());
        existing.setProgramName(dto.getProgramName());
        existing.setRequiredCreditsToGraduate(dto.getRequiredCreditsToGraduate());

        return trainingProgramRepository.save(existing);
    }

    @Override
    public void deleteProgram(String id) {
        TrainingProgram existing = trainingProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chương trình đào tạo để xóa!"));
        trainingProgramRepository.delete(existing);
    }
}