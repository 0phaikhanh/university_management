package com.example.university_management.modules.student.service.impl;

import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.repository.AdminClassRepository;
import com.example.university_management.modules.student.dto.StudentRequestDTO;
import com.example.university_management.modules.student.entity.Student;
import com.example.university_management.modules.student.repository.StudentRepository;
import com.example.university_management.modules.student.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final AdminClassRepository adminClassRepository;

    public StudentServiceImpl(StudentRepository studentRepository, AdminClassRepository adminClassRepository) {
        this.studentRepository = studentRepository;
        this.adminClassRepository = adminClassRepository;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student createStudent(StudentRequestDTO dto) {
        if (studentRepository.existsById(dto.getStudentId())) {
            throw new RuntimeException("Student already exists");
        }

        AdminClass adminClass = adminClassRepository.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Admin Class not found with ID: " + dto.getClassId()));

        Student student = Student.builder()
                .studentId(dto.getStudentId())
                .fullName(dto.getFullName())
                .dateOfBirth(dto.getDateOfBirth())
                .gender(dto.getGender())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .academicStatus(dto.getAcademicStatus())
                .adminClass(adminClass)
                .build();

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(String id, StudentRequestDTO dto) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        AdminClass adminClass = adminClassRepository.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Admin Class not found with ID: " + dto.getClassId()));

        existing.setFullName(dto.getFullName());
        existing.setDateOfBirth(dto.getDateOfBirth());
        existing.setGender(dto.getGender());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAcademicStatus(dto.getAcademicStatus());
        existing.setAdminClass(adminClass);

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(String id){
        Student existing = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(existing);
    }
}
