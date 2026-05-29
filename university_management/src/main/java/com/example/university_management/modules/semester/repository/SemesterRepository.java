package com.example.university_management.modules.semester.repository;

import com.example.university_management.modules.semester.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository <Semester, String>{
}
