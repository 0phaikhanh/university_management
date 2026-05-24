package com.example.university_management.modules.behavioral_score.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BehavioralScoreRequestDTO {

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Size(max = 50, message = "Mã sinh viên tối đa 50 ký tự")
    private String studentId;

    @NotBlank(message = "Mã học kỳ không được để trống")
    @Size(max = 50, message = "Mã học kỳ tối đa 50 ký tự")
    private String semesterId;

    @NotNull(message = "Điểm rèn luyện không được để trống")
    @Min(value = 0, message = "Điểm rèn luyện thấp nhất là 0")
    @Max(value = 100, message = "Điểm rèn luyện cao nhất là 100")
    private Integer totalPoints;

    @NotBlank(message = "Xếp loại không được để trống")
    @Size(max = 50, message = "Xếp loại tối đa 50 ký tự")
    private String classification;
}
