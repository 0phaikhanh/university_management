package com.example.university_management.modules.faculty.service;

import com.example.university_management.modules.faculty.dto.request.CreateFacultyRequest;
import com.example.university_management.modules.faculty.dto.request.UpdateFacultyRequest;
import com.example.university_management.modules.faculty.dto.response.FacultyResponse;

import java.util.List;

public interface FacultyService {

    FacultyResponse create(CreateFacultyRequest request);

    FacultyResponse update(
            String facultyId,
            UpdateFacultyRequest request
    );

    FacultyResponse getById(String facultyId);

    List<FacultyResponse> getAll();

    void delete(String facultyId);
}