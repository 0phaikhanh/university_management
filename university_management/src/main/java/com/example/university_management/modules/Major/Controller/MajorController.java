package com.example.university_management.modules.Major.Controller;

import com.example.university_management.modules.Major.Entity.Major;
import com.example.university_management.modules.Major.Repository.MajorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TableMajor")

public class MajorController {
    private final MajorRepository majorRepository;

    public MajorController(MajorRepository majorRepository){
        this.majorRepository = majorRepository;
    }

    @GetMapping
    public List<Major> getAllMajor(){
        return majorRepository.findAll();
    }

    //find by major_id
    @GetMapping("/{id}")
    public Major getMajorById(@PathVariable String id){
        return majorRepository.findById(id).orElse(null);
    }

}