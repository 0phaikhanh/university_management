package com.example.university_management.modules.adminclass.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminClassRequestDTO {
    @NotBlank(message = "Mã lớp không được để trống")
    @Size(max = 50, message = "Mã lớp tối đa 50 ký tự")
    private String classId;

    @NotBlank(message = "Mã ngành không được để trống")
    @Size(max = 50, message = "Mã ngành tối đa 50 ký tự")
    private String majorId;

    @NotNull(message = "Năm nhập học không được để trống")
    @Min(value = 2000, message = "Năm nhập học phải từ năm 2000 trở đi")
    @Max(value = 2026, message = "Năm nhập học không được vượt quá năm 2026")
    private Integer entranceYear;
}