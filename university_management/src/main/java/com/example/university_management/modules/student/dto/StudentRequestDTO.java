package com.example.university_management.modules.student.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Size(max = 50, message = "Mã sinh viên tối đa 50 ký tự")
    private String studentId;

    @NotBlank(message = "Tên sinh viên không được để trống")
    @Size(max = 255, message = "Tên sinh viên tối đa 255 ký tự")
    private String fullName;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là một ngày trong quá khứ")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Giới tính không được để trống")
    @Size(max = 10, message = "Giới tính tối đa 10 ký tự")
    private String gender;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(max = 255, message = "Email tối đa 255 ký tự")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(max = 20, message = "Số điện thoại tối đa 20 ký tự")
    @Pattern(regexp = "^[0-9]*$", message = "Số điện thoại chỉ chứa các ký tự số")
    private String phone;

    @NotBlank(message = "Mã lớp hành chính không được để trống")
    @Size(max = 50, message = "Mã lớp tối đa 50 ký tự")
    private String classId;

    @NotBlank(message = "Trạng thái học tập không được để trống")
    @Size(max = 50, message = "Trạng thái học tập tối đa 50 ký tự")
    private String academicStatus;
}