package com.example.university_management.modules.lecturer.controller;

import com.example.university_management.modules.lecturer.entity.Lecturer;
import com.example.university_management.modules.lecturer.service.LecturerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public List<Lecturer> getAll() {
        return lecturerService.getAllLecturers();
    }

    @GetMapping("/{id}")
    public Lecturer getById(@PathVariable String id) {
        return lecturerService.getLecturerById(id);
    }

    @PostMapping
    public Lecturer create(@RequestBody Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    @PutMapping("/{id}")
    public Lecturer update(@PathVariable String id,
                           @RequestBody Lecturer lecturer) {
        return lecturerService.updateLecturer(id, lecturer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        lecturerService.deleteLecturer(id);
    }
}