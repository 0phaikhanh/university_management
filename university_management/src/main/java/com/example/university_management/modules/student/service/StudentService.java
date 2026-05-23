package com.example.university_management.modules.student.service;

import com.example.university_management.modules.student.dto.StudentRequestDTO;
import com.example.university_management.modules.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student createStudent (StudentRequestDTO dto);
    Student updateStudent (String id, StudentRequestDTO dto);
    void deleteStudent(String id);
}
