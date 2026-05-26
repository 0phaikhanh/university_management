package com.example.university_management.modules.lecturer.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.lecturer.dto.LecturerRequestDTO;
import com.example.university_management.modules.lecturer.entity.Lecturer;
import com.example.university_management.modules.lecturer.repository.LecturerRepository;
import com.example.university_management.modules.lecturer.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer getLecturerById(String id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer not found with ID: " + id));
    }

    @Override
    public Lecturer createLecturer(LecturerRequestDTO dto) {
        if (lecturerRepository.existsById(dto.getLecturerId())) {
            throw new RuntimeException("Lecturer ID already exists!");
        }

        if (dto.getEmail() != null && lecturerRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Lecturer email already exists!");
        }

        Lecturer lecturer = Lecturer.builder()
                .lecturerId(dto.getLecturerId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .facultyId(dto.getFacultyId())
                .build();

        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer updateLecturer(String id, LecturerRequestDTO dto) {
        Lecturer existing = lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer to update was not found!"));

        if (dto.getEmail() != null) {
            lecturerRepository.findByEmail(dto.getEmail())
                    .filter(lecturer -> !lecturer.getLecturerId().equals(id))
                    .ifPresent(lecturer -> {
                        throw new RuntimeException("Lecturer email already exists!");
                    });
        }

        existing.setFullName(dto.getFullName());
        existing.setEmail(dto.getEmail());
        existing.setFacultyId(dto.getFacultyId());

        return lecturerRepository.save(existing);
    }

    @Override
    public void deleteLecturer(String id) {
        Lecturer existing = lecturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lecturer to delete was not found!"));
        lecturerRepository.delete(existing);
    }
}
