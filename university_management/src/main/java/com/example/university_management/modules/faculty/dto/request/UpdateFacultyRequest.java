package com.example.university_management.modules.faculty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateFacultyRequest {

    @NotBlank(message = "Faculty name is required")
    @Size(max = 255)
    private String facultyName;
}
