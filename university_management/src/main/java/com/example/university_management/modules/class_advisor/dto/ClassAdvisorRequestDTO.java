package com.example.university_management.modules.class_advisor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassAdvisorRequestDTO {

    @NotBlank(message = "Class ID is required")
    @Size(max = 50, message = "Class ID must not exceed 50 characters")
    private String classId;

    @NotBlank(message = "Lecturer ID is required")
    @Size(max = 50, message = "Lecturer ID must not exceed 50 characters")
    private String lecturerId;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;
}
