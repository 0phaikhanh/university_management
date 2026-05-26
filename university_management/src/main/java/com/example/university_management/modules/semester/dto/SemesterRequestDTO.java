package com.example.university_management.modules.semester.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemesterRequestDTO {
    @NotBlank(message = "Semester ID is required")
    @Size(max = 50, message = "Semester ID must not exceed 50 characters")
    private String semesterId;

    @NotBlank(message = "Academic year is required")
    @Size(max = 20, message = "Academic year must not exceed 20 characters, for example 2023-2024")
    private String academicYear;

    @NotNull(message = "Semester number is required")
    @Min(value = 1, message = "Semester number must be at least 1")
    @Max(value = 3, message = "Semester number must be at most 3") // Usually an academic year has at most 3 semesters; summer is 3
    private Integer semesterNumber;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;
}
