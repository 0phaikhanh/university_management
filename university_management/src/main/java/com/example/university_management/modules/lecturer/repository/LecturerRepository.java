package com.example.university_management.modules.lecturer.repository;

import com.example.university_management.modules.lecturer.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {

    boolean existsByEmail(String email);

    Optional<Lecturer> findByEmail(String email);
}
