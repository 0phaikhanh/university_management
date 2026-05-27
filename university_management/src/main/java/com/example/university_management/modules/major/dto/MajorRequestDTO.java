package com.example.university_management.modules.major.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MajorRequestDTO {
    @NotBlank(message = "Major ID is required")
    @Size(max = 50, message = "Major ID must not exceed 50 characters")
    private String majorId;

    @NotBlank(message = "Major name is required")
    @Size(max = 255, message = "Major name must not exceed 255 characters")
    private String majorName;

    @NotBlank(message = "Faculty ID is required")
    @Size(max = 50, message = "Faculty ID must not exceed 50 characters")
    private String facultyId;
}
