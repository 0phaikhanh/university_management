package com.example.university_management.modules.course_class.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseClassRequestDTO {

    @NotBlank(message = "Course class ID is required")
    @Size(max = 50, message = "Course class ID must not exceed 50 characters")
    private String courseClassId;

    @NotBlank(message = "Course ID is required")
    @Size(max = 50, message = "Course ID must not exceed 50 characters")
    private String subjectId;

    @NotBlank(message = "Semester ID is required")
    @Size(max = 50, message = "Semester ID must not exceed 50 characters")
    private String semesterId;

    @Size(max = 50, message = "Lecturer ID must not exceed 50 characters")
    private String lecturerId;

    @NotNull(message = "Maximum enrollment is required")
    @Min(value = 1, message = "Maximum enrollment must be greater than 0")
    private Integer maxCapacity;

    @Size(max = 255, message = "Schedule must not exceed 255 characters")
    private String schedule;

    @Size(max = 50, message = "Classroom must not exceed 50 characters")
    private String room;
}
