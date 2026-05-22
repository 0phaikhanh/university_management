CREATE TABLE faculty (
                         faculty_id VARCHAR(50) PRIMARY KEY,
                         faculty_name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE major (
                       major_id VARCHAR(50) PRIMARY KEY,
                       major_name VARCHAR(255) NOT NULL,
                       faculty_id VARCHAR(50),
                       FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
                           ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE training_program (
                                  program_id VARCHAR(50) PRIMARY KEY,
                                  major_id VARCHAR(50),
                                  program_name VARCHAR(255),
                                  required_credits_to_graduate INT,
                                  FOREIGN KEY (major_id) REFERENCES major(major_id)
                                      ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE subject (
                         subject_id VARCHAR(50) PRIMARY KEY,
                         subject_name VARCHAR(255),
                         total_credits INT,
                         theory_credits INT,
                         practice_credits INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE program_subject (
                                 program_id VARCHAR(50),
                                 subject_id VARCHAR(50),
                                 is_mandatory BOOLEAN DEFAULT TRUE,
                                 suggested_semester INT,

                                 PRIMARY KEY (program_id, subject_id),

                                 FOREIGN KEY (program_id) REFERENCES training_program(program_id)
                                     ON DELETE CASCADE,

                                 FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
                                     ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE lecturer (
                          lecturer_id VARCHAR(50) PRIMARY KEY,
                          full_name VARCHAR(255),
                          email VARCHAR(255) UNIQUE,
                          faculty_id VARCHAR(50),
                          FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
                              ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE admin_class (
                             class_id VARCHAR(50) PRIMARY KEY,
                             major_id VARCHAR(50),
                             entrance_year INT,

                             FOREIGN KEY (major_id) REFERENCES major(major_id)
                                 ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE class_advisor (
                               advisor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               class_id VARCHAR(50),
                               lecturer_id VARCHAR(50),
                               start_date DATE,
                               end_date DATE,

                               FOREIGN KEY (class_id) REFERENCES admin_class(class_id)
                                   ON DELETE CASCADE,

                               FOREIGN KEY (lecturer_id) REFERENCES lecturer(lecturer_id)
                                   ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE student (
                         student_id VARCHAR(50) PRIMARY KEY,
                         full_name VARCHAR(255),
                         date_of_birth DATE,
                         gender VARCHAR(10),
                         email VARCHAR(255) UNIQUE,
                         phone VARCHAR(20),
                         class_id VARCHAR(50),
                         academic_status VARCHAR(50),

                         FOREIGN KEY (class_id) REFERENCES admin_class(class_id)
                             ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE semester (
                          semester_id VARCHAR(50) PRIMARY KEY,
                          academic_year VARCHAR(20),
                          semester_number INT,
                          start_date DATE,
                          end_date DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE course_class (
                              course_class_id VARCHAR(50) PRIMARY KEY,
                              subject_id VARCHAR(50),
                              semester_id VARCHAR(50),
                              lecturer_id VARCHAR(50),
                              max_capacity INT,
                              schedule VARCHAR(255),
                              room VARCHAR(50),

                              FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
                                  ON DELETE CASCADE,

                              FOREIGN KEY (semester_id) REFERENCES semester(semester_id)
                                  ON DELETE CASCADE,

                              FOREIGN KEY (lecturer_id) REFERENCES lecturer(lecturer_id)
                                  ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE student_course_result (
                                       result_id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                       student_id VARCHAR(50),
                                       course_class_id VARCHAR(50),

                                       reg_type VARCHAR(50),

                                       attendance_score FLOAT,
                                       midterm_score FLOAT,
                                       final_score FLOAT,
                                       total_10 FLOAT,
                                       total_4 FLOAT,
                                       grade_letter VARCHAR(5),

                                       FOREIGN KEY (student_id) REFERENCES student(student_id)
                                           ON DELETE CASCADE,

                                       FOREIGN KEY (course_class_id) REFERENCES course_class(course_class_id)
                                           ON DELETE CASCADE,

                                       UNIQUE (student_id, course_class_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE behavioral_score (
                                  behavioral_score_id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                  student_id VARCHAR(50),
                                  semester_id VARCHAR(50),

                                  total_points INT,
                                  classification VARCHAR(50),

                                  FOREIGN KEY (student_id) REFERENCES student(student_id)
                                      ON DELETE CASCADE,

                                  FOREIGN KEY (semester_id) REFERENCES semester(semester_id)
                                      ON DELETE CASCADE,

                                  UNIQUE (student_id, semester_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tuition (
                         tuition_id BIGINT AUTO_INCREMENT PRIMARY KEY,

                         student_id VARCHAR(50),
                         semester_id VARCHAR(50),

                         total_fee DECIMAL(12,2),
                         discount_amount DECIMAL(12,2),
                         paid_amount DECIMAL(12,2),

                         status VARCHAR(50),

                         FOREIGN KEY (student_id) REFERENCES student(student_id)
                             ON DELETE CASCADE,

                         FOREIGN KEY (semester_id) REFERENCES semester(semester_id)
                             ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tuition_detail (
                                tuition_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                tuition_id BIGINT,
                                subject_id VARCHAR(50),

                                credits INT,
                                amount DECIMAL(12,2),

                                FOREIGN KEY (tuition_id) REFERENCES tuition(tuition_id)
                                    ON DELETE CASCADE,

                                FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
                                    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_student_class ON student(class_id);
CREATE INDEX idx_course_semester ON course_class(semester_id);
CREATE INDEX idx_result_student ON student_course_result(student_id);
CREATE INDEX idx_tuition_student ON tuition(student_id);
