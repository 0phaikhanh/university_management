package com.example.university_management.modules.student.service;

import com.example.university_management.modules.student.dto.StudentRequestDTO;
import com.example.university_management.modules.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);    Student getStudentById(String id);
    Student createStudent (StudentRequestDTO dto);
    Student updateStudent (String id, StudentRequestDTO dto);
    void deleteStudent(String id);
}
