package com.example.university_management.modules.adminclass.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminClassRequestDTO {
    @NotBlank(message = "Class ID is required")
    @Size(max = 50, message = "Class ID must not exceed 50 characters")
    private String classId;

    @NotBlank(message = "Major ID is required")
    @Size(max = 50, message = "Major ID must not exceed 50 characters")
    private String majorId;

    @NotNull(message = "Admission year is required")
    @Min(value = 2000, message = "Admission year must be 2000 or later")
    @Max(value = 2026, message = "Admission year must not be greater than 2026")
    private Integer entranceYear;
}
