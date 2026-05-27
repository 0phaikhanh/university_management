package com.example.university_management.modules.lecturer.service;

import com.example.university_management.modules.lecturer.dto.LecturerRequestDTO;
import com.example.university_management.modules.lecturer.entity.Lecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LecturerService {

    Page<Lecturer> getAllLecturers(Pageable pageable);

    Lecturer getLecturerById(String id);

    Lecturer createLecturer(LecturerRequestDTO dto);

    Lecturer updateLecturer(String id, LecturerRequestDTO dto);

    void deleteLecturer(String id);
}
