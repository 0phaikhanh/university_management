package com.example.university_management.modules.lecturer.service;

import com.example.university_management.modules.lecturer.entity.Lecturer;
import java.util.List;

public interface LecturerService {
    List<Lecturer> getAllLecturers();
    Lecturer getLecturerById(String id);
    Lecturer createLecturer(Lecturer lecturer);
    Lecturer updateLecturer(String id, Lecturer lecturer);
    void deleteLecturer(String id);
}
