package com.example.university_management.modules.major.Repository;

import com.example.university_management.modules.major.Entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
}
