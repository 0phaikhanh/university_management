package com.example.university_management.modules.lecturer.service.impl;

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
        return lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Lecturer not found"));
    }

    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        if (lecturerRepository.existsById(lecturer.getLecturerId())) {
            throw new RuntimeException("Lecturer already exists");
        }
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer updateLecturer(String id, Lecturer lecturer) {
        Lecturer existing = lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Lecturer not found"));
        existing.setFullName(lecturer.getFullName());
        existing.setEmail(lecturer.getEmail());
        existing.setFacultyId(lecturer.getFacultyId());

        return lecturerRepository.save(existing);
    }

    @Override
    public void deleteLecturer(String id) {
        Lecturer existing = lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Lecturer not found"));
        lecturerRepository.delete(existing);
    }
}