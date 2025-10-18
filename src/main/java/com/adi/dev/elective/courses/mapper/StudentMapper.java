package com.adi.dev.elective.courses.mapper;

import com.adi.dev.elective.courses.dto.StudentCreateDTO;
import com.adi.dev.elective.courses.dto.StudentResponseDTO;
import com.adi.dev.elective.courses.dto.StudentUpdateDTO;
import com.adi.dev.elective.courses.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponseDTO toResponseDTO(Student student);

    StudentCreateDTO fromCreateDTO(StudentCreateDTO student);


    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "grade", source = "grade")
    @Mapping(target = "studyYear", source = "studyYear")
    void updateEntityFromDTO(StudentUpdateDTO studentUpdateDTO, @MappingTarget Student student);

}
