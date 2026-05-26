package com.example.university_management.modules.student.controller;

import com.example.university_management.modules.student.dto.StudentRequestDTO;
import com.example.university_management.modules.student.entity.Student;
import com.example.university_management.modules.student.service.StudentService;
import com.example.university_management.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ApiResponse<List<Student>> getAll() {
        List<Student> students = studentService.getAllStudents();
        return new ApiResponse<>("Get all students successfully", students);
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> getById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        return new ApiResponse<>("Get student successfully", student);
    }

    @PostMapping
    public ApiResponse<Student> create(@Valid @RequestBody StudentRequestDTO dto) {
        Student createdStudent = studentService.createStudent(dto);
        return new ApiResponse<>("Create student successfully", createdStudent);
    }

    @PutMapping("/{id}")
    public ApiResponse<Student> update(@PathVariable String id, @Valid @RequestBody StudentRequestDTO dto) {
        Student updatedStudent = studentService.updateStudent(id, dto);
        return new ApiResponse<>("Update student successfully", updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ApiResponse<>("Delete student successfully", null);
    }

}
