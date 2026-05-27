package com.example.university_management.modules.trainingprogram.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import com.example.university_management.modules.trainingprogram.repository.TrainingProgramRepository;
import com.example.university_management.modules.trainingprogram.service.TrainingProgramService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class
TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;

    public TrainingProgramServiceImpl(TrainingProgramRepository trainingProgramRepository) {
        this.trainingProgramRepository = trainingProgramRepository;
    }

    @Override
    public Page<TrainingProgram> getAllPrograms(Pageable pageable) {
        return trainingProgramRepository.findAll(pageable);
    }

    @Override
    public TrainingProgram getProgramById(String id) {
        return trainingProgramRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training program not found with ID: " + id));
    }

    @Override
    public TrainingProgram createProgram(TrainingProgramRequestDTO dto) {
        if (trainingProgramRepository.existsById(dto.getProgramId())) {
            throw new RuntimeException("Training program ID already exists!");
        }

        // TODO: Check whether Major exists here

        TrainingProgram program = TrainingProgram.builder()
                .programId(dto.getProgramId())
                .majorId(dto.getMajorId()) // Store as String
                .programName(dto.getProgramName())
                .requiredCreditsToGraduate(dto.getRequiredCreditsToGraduate())
                .build();

        return trainingProgramRepository.save(program);
    }

    @Override
    public TrainingProgram updateProgram(String id, TrainingProgramRequestDTO dto) {
        TrainingProgram existing = trainingProgramRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training program to update was not found!"));

        existing.setMajorId(dto.getMajorId());
        existing.setProgramName(dto.getProgramName());
        existing.setRequiredCreditsToGraduate(dto.getRequiredCreditsToGraduate());

        return trainingProgramRepository.save(existing);
    }

    @Override
    public void deleteProgram(String id) {
        TrainingProgram existing = trainingProgramRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training program to delete was not found!"));
        trainingProgramRepository.delete(existing);
    }
}
