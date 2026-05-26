package com.example.university_management.modules.lecturer.service;

import com.example.university_management.modules.lecturer.dto.LecturerRequestDTO;
import com.example.university_management.modules.lecturer.entity.Lecturer;

import java.util.List;

public interface LecturerService {

    List<Lecturer> getAllLecturers();

    Lecturer getLecturerById(String id);

    Lecturer createLecturer(LecturerRequestDTO dto);

    Lecturer updateLecturer(String id, LecturerRequestDTO dto);

    void deleteLecturer(String id);
}
