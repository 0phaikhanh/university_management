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
    @NotBlank(message = "Mã học kỳ không được để trống")
    @Size(max = 50, message = "Mã học kỳ tối đa 50 ký tự")
    private String semesterId;

    @NotBlank(message = "Năm học không được để trống")
    @Size(max = 20, message = "Năm học tối đa 20 ký tự (VD: 2023-2024)")
    private String academicYear;

    @NotNull(message = "Học kỳ (số) không được để trống")
    @Min(value = 1, message = "Học kỳ nhỏ nhất là 1")
    @Max(value = 3, message = "Học kỳ lớn nhất là 3") // Thường 1 năm có tối đa 3 kỳ (kỳ Hè là 3)
    private Integer semesterNumber;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate startDate;

    @NotNull(message = "Ngày kết thúc không được để trống")
    private LocalDate endDate;
}
