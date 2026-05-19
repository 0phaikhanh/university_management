package com.example.university_management.modules.student.service;

import com.example.university_management.modules.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student createStudent (Student student);
    Student updateStudent (String id,Student student);
    void deleteStudent(String id);
}
