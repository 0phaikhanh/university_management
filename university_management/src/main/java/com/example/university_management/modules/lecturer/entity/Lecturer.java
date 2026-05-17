package com.example.university_management.modules.lecturer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @Column(name = "lecturer_id", length = 50)
    private String lecturerId;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "faculty_id", length = 50)
    private String facultyId;

    // Constructor rỗng
    public Lecturer() {
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}
