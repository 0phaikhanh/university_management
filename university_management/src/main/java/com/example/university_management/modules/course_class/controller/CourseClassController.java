package com.example.university_management.modules.course_class.controller;

import com.example.university_management.modules.course_class.common.ApiResponse;
import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;
import com.example.university_management.modules.course_class.service.CourseClassService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-classes")
public class CourseClassController {

    private final CourseClassService courseClassService;

    public CourseClassController(CourseClassService courseClassService) {
        this.courseClassService = courseClassService;
    }

    @GetMapping
    public ApiResponse<List<CourseClass>> getAll() {
        return new ApiResponse<>("Lấy danh sách lớp học phần thành công", courseClassService.getAllCourseClasses());
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseClass> getById(@PathVariable String id) {
        return new ApiResponse<>("Lấy thông tin lớp học phần thành công", courseClassService.getCourseClassById(id));
    }

    @PostMapping
    public ApiResponse<CourseClass> create(@Valid @RequestBody CourseClassRequestDTO dto) {
        return new ApiResponse<>("Thêm lớp học phần thành công", courseClassService.createCourseClass(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<CourseClass> update(@PathVariable String id, @Valid @RequestBody CourseClassRequestDTO dto) {
        return new ApiResponse<>("Cập nhật lớp học phần thành công", courseClassService.updateCourseClass(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        courseClassService.deleteCourseClass(id);
        return new ApiResponse<>("Xóa lớp học phần thành công", null);
    }
}
