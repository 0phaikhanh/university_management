package com.example.university_management.modules.faculty.service.impl;

import com.example.university_management.modules.faculty.dto.request.CreateFacultyRequest;
import com.example.university_management.modules.faculty.dto.request.UpdateFacultyRequest;
import com.example.university_management.modules.faculty.dto.response.FacultyResponse;
import com.example.university_management.modules.faculty.entity.Faculty;
import com.example.university_management.modules.faculty.mapper.FacultyMapper;
import com.example.university_management.modules.faculty.repository.FacultyRepository;
import com.example.university_management.modules.faculty.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    private final FacultyMapper facultyMapper;


    @Override
    public FacultyResponse create(CreateFacultyRequest request) {

        if (facultyRepository.existsById(request.getFacultyId())) {
            throw new RuntimeException("Faculty ID already exists");
        }

        Faculty faculty = Faculty.builder()
                .facultyId(request.getFacultyId())
                .facultyName(request.getFacultyName())
                .build();

        facultyRepository.save(faculty);

        return facultyMapper.toResponse(faculty);
    }

    @Override
    public FacultyResponse update(
            String facultyId,
            UpdateFacultyRequest request
    ) {

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found"));

        faculty.setFacultyName(request.getFacultyName());

        facultyRepository.save(faculty);

        return facultyMapper.toResponse(faculty);
    }

    @Override
    @Transactional(readOnly = true)
    public FacultyResponse getById(String facultyId) {

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found"));

        return facultyMapper.toResponse(faculty);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacultyResponse> getAll() {

        return facultyRepository.findAll()
                .stream()
                .map(facultyMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(String facultyId) {

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found"));

        facultyRepository.delete(faculty);
    }
}