package com.example.university_management.modules.student_course_result.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseResultRequestDTO {

    @NotBlank(message = "Student ID is required")
    @Size(max = 50, message = "Student ID must not exceed 50 characters")
    private String studentId;

    @NotBlank(message = "Course class ID is required")
    @Size(max = 50, message = "Course class ID must not exceed 50 characters")
    private String courseClassId;

    @Size(max = 50, message = "Registration type must not exceed 50 characters")
    private String regType;

    @Min(value = 0, message = "Attendance score must not be less than 0")
    @Max(value = 10, message = "Attendance score must not be greater than 10")
    private Float attendanceScore;

    @Min(value = 0, message = "Midterm score must not be less than 0")
    @Max(value = 10, message = "Midterm score must not be greater than 10")
    private Float midtermScore;

    @Min(value = 0, message = "Final exam score must not be less than 0")
    @Max(value = 10, message = "Final exam score must not be greater than 10")
    private Float finalScore;

    @Min(value = 0, message = "Score on 10-point scale must not be less than 0")
    @Max(value = 10, message = "Score on 10-point scale must not be greater than 10")
    private Float total10;

    @Min(value = 0, message = "Score on 4-point scale must not be less than 0")
    @Max(value = 4, message = "Score on 4-point scale must not be greater than 4")
    private Float total4;

    @Size(max = 5, message = "Letter grade must not exceed 5 characters")
    private String gradeLetter;
}
