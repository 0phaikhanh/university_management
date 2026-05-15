package com.example.university_management.modules.faculty.repository;

import com.example.university_management.modules.faculty.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository
        extends JpaRepository<Faculty, String> {

    boolean existsByFacultyName(String facultyName);
}