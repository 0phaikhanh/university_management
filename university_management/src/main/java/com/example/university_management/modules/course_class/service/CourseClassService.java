package com.example.university_management.modules.course_class.service;

import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;

import java.util.List;

public interface CourseClassService {
    List<CourseClass> getAllCourseClasses();
    CourseClass getCourseClassById(String id);
    CourseClass createCourseClass(CourseClassRequestDTO dto);
    CourseClass updateCourseClass(String id, CourseClassRequestDTO dto);
    void deleteCourseClass(String id);
}
