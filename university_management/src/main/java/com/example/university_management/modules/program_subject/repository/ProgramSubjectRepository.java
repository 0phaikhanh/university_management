package com.example.university_management.modules.program_subject.repository;

import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramSubjectRepository extends JpaRepository<ProgramSubject, ProgramSubjectId> {
}
