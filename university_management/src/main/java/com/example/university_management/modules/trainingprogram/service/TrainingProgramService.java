package com.example.university_management.modules.trainingprogram.service;

import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingProgramService {
    Page<TrainingProgram> getAllPrograms(Pageable pageable);
    TrainingProgram getProgramById(String id);
    TrainingProgram createProgram(TrainingProgramRequestDTO dto);
    TrainingProgram updateProgram(String id, TrainingProgramRequestDTO dto);
    void deleteProgram(String id);
}
