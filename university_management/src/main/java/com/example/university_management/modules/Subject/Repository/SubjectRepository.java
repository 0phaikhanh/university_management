package com.example.university_management.modules.Subject.Repository;

import com.example.university_management.modules.Subject.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
