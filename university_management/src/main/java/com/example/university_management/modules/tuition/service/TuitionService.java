package com.example.university_management.modules.tuition.service;

import com.example.university_management.modules.tuition.dto.TuitionRequestDTO;
import com.example.university_management.modules.tuition.entity.Tuition;
import java.util.List;

public interface TuitionService {
    List<Tuition> getAllTuitions();
    Tuition getTuitionById(Long id);
    Tuition createTuition(TuitionRequestDTO dto);
    Tuition updateTuition(Long id, TuitionRequestDTO dto);
    void deleteTuition(Long id);
}
