package com.example.university_management.modules.subject.repository;

import com.example.university_management.modules.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
