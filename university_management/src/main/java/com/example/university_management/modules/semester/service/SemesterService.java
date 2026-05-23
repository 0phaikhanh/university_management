package com.example.university_management.modules.semester.service;

import com.example.university_management.modules.semester.dto.SemesterRequestDTO;
import com.example.university_management.modules.semester.entity.Semester;

import java.util.List;

public interface SemesterService {
    List<Semester> getAllSemesters();
    Semester getSemesterById(String id);
    Semester createSemester(SemesterRequestDTO dto);
    Semester updateSemester(String id, SemesterRequestDTO dto);
    void deleteSemester(String id);
}

