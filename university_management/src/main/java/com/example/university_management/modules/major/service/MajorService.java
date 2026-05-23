package com.example.university_management.modules.major.service;

import com.example.university_management.modules.major.entity.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAllMajor();
    Major getMajorById(String id);
    Major createMajor(Major major);
    Major updateMajor(String id, Major major);
    void deleteMajor(String id);
}
