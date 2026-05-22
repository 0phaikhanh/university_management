package com.example.university_management.modules.ProgramSubject.Entity;

import com.example.university_management.modules.Subject.Entity.Subject;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "program_subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProgramSubject {
    @EmbeddedId
    private ProgramSubjectId id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "is_mandatory", nullable = false)
    private Boolean isMandatory;

    @Column(name = "suggested_semester")
    private Integer suggestedSemester;
}
