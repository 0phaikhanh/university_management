package com.example.university_management.modules.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDTO {
    private String token;

    @Builder.Default
    private String type = "Bearer";
}
