package com.example.university_management.modules.major.service.impl;

import com.example.university_management.modules.major.entity.Major;
import com.example.university_management.modules.major.repository.MajorRepository;
import com.example.university_management.modules.major.service.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MajorServiceImpl implements MajorService{
    private final MajorRepository majorRepository;

    public MajorServiceImpl (MajorRepository majorRepository){
        this.majorRepository = majorRepository;
    }

    @Override
    public List<Major> getAllMajor(){
        return majorRepository.findAll();
    }

    @Override
    public Major getMajorById(String id){
        return majorRepository.findById(id).orElseThrow(() -> new RuntimeException("Major not found!"));
    }

    @Override
    public Major createMajor(Major major){
        if(majorRepository.existsById(major.getMajorId())){
            throw new RuntimeException("Major already exists");
        }
        return majorRepository.save(major);
    }

    @Override
    public Major updateMajor(String id, Major major){
        Major existing = majorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Major not found!"));

        existing.setMajorName(major.getMajorName());
        existing.setFacultyId(major.getFacultyId());
        return majorRepository.save(existing);
    }

    @Override
    public void deleteMajor(String id){
        Major existing = majorRepository.findById(id).orElseThrow(() -> new RuntimeException("Major not found!"));
        majorRepository.delete(existing);
    }
}
