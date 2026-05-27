package com.example.university_management.modules.faculty.service;

import com.example.university_management.modules.faculty.dto.request.CreateFacultyRequest;
import com.example.university_management.modules.faculty.dto.request.UpdateFacultyRequest;
import com.example.university_management.modules.faculty.dto.response.FacultyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacultyService {

    FacultyResponse create(CreateFacultyRequest request);

    FacultyResponse update(
            String facultyId,
            UpdateFacultyRequest request
    );

    FacultyResponse getById(String facultyId);

    Page<FacultyResponse> getAll(Pageable pageable);

    void delete(String facultyId);
}
