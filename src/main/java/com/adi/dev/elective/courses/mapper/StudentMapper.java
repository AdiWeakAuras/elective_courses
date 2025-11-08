package com.adi.dev.elective.courses.mapper;

import com.adi.dev.elective.courses.dto.StudentCreateDTO;
import com.adi.dev.elective.courses.dto.StudentResponseDTO;
import com.adi.dev.elective.courses.dto.StudentUpdateDTO;
import com.adi.dev.elective.courses.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentMapper {

    // Map entity -> response DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "faculty", target = "faculty")
    @Mapping(source = "studyYear", target = "studyYear")
    @Mapping(source = "grade", target = "grade")
    StudentResponseDTO toResponseDTO(Student student);

    // Map create DTO -> entity
    // ID will be null; other fields are copied automatically
    Student fromCreateDTO(StudentCreateDTO dto);

    // Update existing entity with non-null fields from update DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true) // never overwrite ID
    void updateEntityFromDTO(StudentUpdateDTO dto, @MappingTarget Student student);
}
