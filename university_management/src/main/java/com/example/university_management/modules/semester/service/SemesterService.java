package com.example.university_management.modules.semester.service;

import com.example.university_management.modules.semester.dto.SemesterRequestDTO;
import com.example.university_management.modules.semester.entity.Semester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SemesterService {
    Page<Semester> getAllSemesters(Pageable pageable);
    Semester getSemesterById(String id);
    Semester createSemester(SemesterRequestDTO dto);
    Semester updateSemester(String id, SemesterRequestDTO dto);
    void deleteSemester(String id);
}
