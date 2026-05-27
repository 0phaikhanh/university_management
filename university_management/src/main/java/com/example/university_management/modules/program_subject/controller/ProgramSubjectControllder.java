package com.example.university_management.modules.program_subject.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.program_subject.dto.ProgramSubjectRequestDTO;
import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import com.example.university_management.modules.program_subject.service.ProgramSubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program-subject")
@RequiredArgsConstructor

public class ProgramSubjectControllder {
    private final ProgramSubjectService programSubjectService;

    @GetMapping
    public ApiResponse<PageResponse<ProgramSubject>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "majorId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir){
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<ProgramSubject> majorPage = programSubjectService.getAllProgramSubject(pageable);
        return new ApiResponse<>("Major retrieved successfully", PageResponse.of(majorPage));
    }

    @GetMapping("/{programId}/{subjectId}")
    public ApiResponse<ProgramSubject> getById(@PathVariable ProgramSubjectId id) {
        return new ApiResponse<>("Lecturer retrieved successfully", programSubjectService.getProgramSubjectById(id));
    }

    @PostMapping
    public ApiResponse<ProgramSubject> create(@Valid @RequestBody ProgramSubjectRequestDTO dto) {
        return new ApiResponse<>("Lecturer created successfully", programSubjectService.createProgramSubject(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<ProgramSubject> update(@PathVariable ProgramSubjectId id, @Valid @RequestBody ProgramSubjectRequestDTO dto) {
        return new ApiResponse<>("Lecturer updated successfully", programSubjectService.updateProgramSubject(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable ProgramSubjectId id) {
        programSubjectService.deleteProgramSubject(id);
        return new ApiResponse<>("Lecturer deleted successfully", null);
    }
}
