package com.example.university_management.modules.lecturer.repository;

import com.example.university_management.modules.lecturer.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository
        extends JpaRepository<Lecturer, String> {
}