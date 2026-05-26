package com.example.university_management.modules.faculty.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultyResponse {

    private String facultyId;

    private String facultyName;
}
