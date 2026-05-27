package com.example.university_management.modules.subject.entity;

//import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Subject {
    @Id
    @Column(name = "subject_id", length = 50)
    private String subjectId;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "total_credits", length = 11)
    private Integer totalCredits;

    @Column(name = "theory_credits", length = 11)
    private Integer theoryCredits;

    @Column(name = "practice_credits", length = 11)
    private Integer practiceCredits;

//    @OneToMany(mappedBy = "subject")
//    @JsonIgnore
//    private List<ProgramSubject> programSubject;
}
