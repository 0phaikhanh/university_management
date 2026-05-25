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

    @NotBlank(message = "Mã lớp không được để trống")
    @Size(max = 50, message = "Mã lớp tối đa 50 ký tự")
    private String classId;

    @NotBlank(message = "Mã giảng viên không được để trống")
    @Size(max = 50, message = "Mã giảng viên tối đa 50 ký tự")
    private String lecturerId;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate startDate;

    @NotNull(message = "Ngày kết thúc không được để trống")
    private LocalDate endDate;
}
