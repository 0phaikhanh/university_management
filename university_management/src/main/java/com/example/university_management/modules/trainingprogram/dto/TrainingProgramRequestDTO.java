package com.example.university_management.modules.trainingprogram.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgramRequestDTO {

    @NotBlank(message = "Mã chương trình đào tạo không được để trống")
    @Size(max = 50, message = "Mã chương trình đào tạo tối đa 50 ký tự")
    private String programId;

    @NotBlank(message = "Mã ngành không được để trống")
    @Size(max = 50, message = "Mã ngành tối đa 50 ký tự")
    private String majorId;

    @NotBlank(message = "Tên chương trình đào tạo không được để trống")
    @Size(max = 255, message = "Tên chương trình đào tạo tối đa 255 ký tự")
    private String programName;

    @NotNull(message = "Số tín chỉ yêu cầu tốt nghiệp không được để trống")
    @Min(value = 1, message = "Số tín chỉ yêu cầu tốt nghiệp phải lớn hơn 0")
    private Integer requiredCreditsToGraduate;
}