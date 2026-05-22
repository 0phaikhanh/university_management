package com.example.university_management.modules.ProgramSubject.Repository;

import com.example.university_management.modules.ProgramSubject.Entity.ProgramSubject;
import com.example.university_management.modules.ProgramSubject.Entity.ProgramSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramSubjectRepository extends JpaRepository<ProgramSubject, ProgramSubjectId> {
}
