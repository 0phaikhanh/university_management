package com.example.university_management.modules.major.controller;

import com.example.university_management.modules.major.entity.Major;
import com.example.university_management.modules.major.service.MajorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/major")

public class MajorController {
    private final MajorService majorService;

    public MajorController(MajorService majorService){
        this.majorService = majorService;
    }

    @GetMapping
    public List<Major> getAll(){
        return majorService.getAllMajor();
    }

    @GetMapping("/{id}")
    public Major getById(@PathVariable String id){
        return majorService.getMajorById(id);
    }

    @PostMapping
    public Major create(@RequestBody Major major){
        return majorService.createMajor(major);
    }

    @PutMapping("/{id}")
    public Major upadte(@PathVariable String id, @RequestBody Major major){
        return majorService.updateMajor(id, major);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        majorService.deleteMajor(id);
    }
}
