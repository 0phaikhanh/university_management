package com.example.university_management.modules.course_class.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;
import com.example.university_management.modules.course_class.service.CourseClassService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-classes")
public class CourseClassController {

    private final CourseClassService courseClassService;

    public CourseClassController(CourseClassService courseClassService) {
        this.courseClassService = courseClassService;
    }

    @GetMapping
    public ApiResponse<PageResponse<CourseClass>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "courseClassId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<CourseClass> courseClassPage = courseClassService.getAllCourseClasses(pageable);
        return new ApiResponse<>("Course classes retrieved successfully", PageResponse.of(courseClassPage));
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseClass> getById(@PathVariable String id) {
        return new ApiResponse<>("Course class retrieved successfully", courseClassService.getCourseClassById(id));
    }

    @PostMapping
    public ApiResponse<CourseClass> create(@Valid @RequestBody CourseClassRequestDTO dto) {
        return new ApiResponse<>("Course class created successfully", courseClassService.createCourseClass(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<CourseClass> update(@PathVariable String id, @Valid @RequestBody CourseClassRequestDTO dto) {
        return new ApiResponse<>("Course class updated successfully", courseClassService.updateCourseClass(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        courseClassService.deleteCourseClass(id);
        return new ApiResponse<>("Course class deleted successfully", null);
    }
}
