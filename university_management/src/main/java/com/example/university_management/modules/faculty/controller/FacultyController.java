package com.example.university_management.modules.faculty.controller;

import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.faculty.dto.request.CreateFacultyRequest;
import com.example.university_management.modules.faculty.dto.request.UpdateFacultyRequest;
import com.example.university_management.modules.faculty.dto.response.FacultyResponse;
import com.example.university_management.modules.faculty.service.FacultyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping
    public ResponseEntity<FacultyResponse> create(
            @Valid @RequestBody CreateFacultyRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(facultyService.create(request));
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> getById(
            @PathVariable String facultyId
    ) {

        return ResponseEntity.ok(
                facultyService.getById(facultyId)
        );
    }

    @GetMapping
    public ResponseEntity<PageResponse<FacultyResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "facultyId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<FacultyResponse> facultyPage = facultyService.getAll(pageable);

        return ResponseEntity.ok(
                PageResponse.of(facultyPage)
        );
    }

    @PutMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> update(
            @PathVariable String facultyId,
            @Valid @RequestBody UpdateFacultyRequest request
    ) {

        return ResponseEntity.ok(
                facultyService.update(facultyId, request)
        );
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> delete(
            @PathVariable String facultyId
    ) {

        facultyService.delete(facultyId);

        return ResponseEntity.noContent().build();
    }
}
