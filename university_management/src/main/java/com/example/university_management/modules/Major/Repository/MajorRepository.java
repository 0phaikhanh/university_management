package com.example.university_management.modules.Major.Repository;

import com.example.university_management.modules.Major.Entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
}
