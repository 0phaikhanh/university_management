package com.example.university_management.modules.tuition.repository;

import com.example.university_management.modules.tuition.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TuitionRepository extends JpaRepository<Tuition, Long> {
    Optional<Tuition> findByStudentIdAndSemesterId(String studentId, String semesterId);
}
