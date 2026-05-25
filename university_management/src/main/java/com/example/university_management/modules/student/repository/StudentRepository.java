package com.example.university_management.modules.student.repository;

import com.example.university_management.modules.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
