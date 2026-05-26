package com.example.university_management.modules.student.controller;

import com.example.university_management.common.PageResponse;
import com.example.university_management.modules.student.dto.StudentRequestDTO;
import com.example.university_management.modules.student.entity.Student;
import com.example.university_management.modules.student.service.StudentService;
import com.example.university_management.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ApiResponse<PageResponse<Student>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "studentId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        // 1. Lấy dữ liệu Page từ Service
        Page<Student> studentPage = studentService.getAllStudents(pageable);

        // 2. Convert sang cấu hình PageResponse gọn đẹp của mình
        PageResponse<Student> formattedPage = PageResponse.of(studentPage);

        // 3. Trả về cho client
        return new ApiResponse<>("Get students successfully", formattedPage);
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
