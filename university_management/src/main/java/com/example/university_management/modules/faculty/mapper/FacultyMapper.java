package com.example.university_management.modules.faculty.mapper;

import com.example.university_management.modules.faculty.dto.response.FacultyResponse;
import com.example.university_management.modules.faculty.entity.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

    FacultyResponse toResponse(Faculty faculty);
}