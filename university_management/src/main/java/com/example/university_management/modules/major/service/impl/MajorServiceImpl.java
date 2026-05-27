package com.example.university_management.modules.major.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.major.dto.MajorRequestDTO;
import com.example.university_management.modules.major.entity.Major;
import com.example.university_management.modules.major.repository.MajorRepository;
import com.example.university_management.modules.major.service.MajorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MajorServiceImpl implements MajorService{
    private final MajorRepository majorRepository;

    public MajorServiceImpl (MajorRepository majorRepository){
        this.majorRepository = majorRepository;
    }

    @Override
    public Page<Major> getAllMajor(Pageable pageable){
        return majorRepository.findAll(pageable);
    }

    @Override
    public Major getMajorById(String id){
        return majorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Major not found with ID: " + id));
    }

    @Override
    public Major createMajor(MajorRequestDTO dto){
        if(majorRepository.existsById(dto.getMajorId())){
            throw new RuntimeException("Major already exists");
        }

        Major major = Major.builder()
                .majorId(dto.getMajorId())
                .majorName(dto.getMajorName())
                .facultyId(dto.getFacultyId())
                .build();
        return majorRepository.save(major);
    }

    @Override
    public Major updateMajor(String id, MajorRequestDTO dto){
        Major existing = majorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Major to update was not found!"));

        existing.setMajorName(dto.getMajorName());
        existing.setFacultyId(dto.getFacultyId());
        return majorRepository.save(existing);
    }

    @Override
    public void deleteMajor(String id){
        Major existing = majorRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Major to delete was not found"));
        majorRepository.delete(existing);
    }
}

