package com.example.university_management.modules.student.service.impl;

import com.example.university_management.modules.student.entity.Student;
import com.example.university_management.modules.student.repository.StudentRepository;
import com.example.university_management.modules.student.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
    public Student createStudent(Student student){
        if(studentRepository.existsById(student.getStudentId())){
            throw new RuntimeException("Student already exists");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(String id, Student student){
        Student existing = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setFullName(student.getFullName());
        existing.setDateOfBirth(student.getDateOfBirth());
        existing.setGender(student.getGender());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setAcademicStatus(student.getAcademicStatus());
        existing.setAdminClass(student.getAdminClass());
        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(String id){
        Student existing = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(existing);
    }
}
