package com.example.university_management.modules.course_class.service;

import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseClassService {
    Page<CourseClass> getAllCourseClasses(Pageable pageable);
    CourseClass getCourseClassById(String id);
    CourseClass createCourseClass(CourseClassRequestDTO dto);
    CourseClass updateCourseClass(String id, CourseClassRequestDTO dto);
    void deleteCourseClass(String id);
}
