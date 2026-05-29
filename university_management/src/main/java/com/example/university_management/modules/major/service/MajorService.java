package com.example.university_management.modules.major.service;

import com.example.university_management.modules.major.entity.Major;
import com.example.university_management.modules.major.dto.MajorRequestDTO;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

public interface MajorService {
    Page<Major> getAllMajor(Pageable pageable);
    Major getMajorById(String id);
    Major createMajor(MajorRequestDTO dto);
    Major updateMajor(String id, MajorRequestDTO dto);
    void deleteMajor(String id);
}
