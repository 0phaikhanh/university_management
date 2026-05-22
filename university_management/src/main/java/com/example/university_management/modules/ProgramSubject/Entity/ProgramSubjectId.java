package com.example.university_management.modules.ProgramSubject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProgramSubjectId implements Serializable {
    @Column(name = "program_id", length = 50)
    private String programId;

    @Column(name = "subject_id", length = 50)
    private String subjectId;
}
