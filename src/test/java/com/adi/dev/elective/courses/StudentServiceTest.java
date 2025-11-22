package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.dto.StudentCreateDTO;
import com.adi.dev.elective.courses.dto.StudentResponseDTO;
import com.adi.dev.elective.courses.entity.Student;
import com.adi.dev.elective.courses.mapper.StudentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentMapper studentMapper;

    @Test
    @DisplayName("Create Student - Success")
    void createStudentSuccessfully() {
        StudentCreateDTO dto = new StudentCreateDTO();

        // mocking
        Student student = new Student("John Doe", 9, 2, "Engineering");
        when(studentMapper.fromCreateDTO(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        var responseDto = new StudentResponseDTO();
        responseDto.setId(1L);
        when(studentMapper.toResponseDTO(student)).thenReturn(responseDto);

        // action
        StudentResponseDTO response = studentService.createStudent(dto);

        // assert
        assertNotNull(response);
        assertEquals(1L, (long) response.getId());

        verify(studentMapper, times(1)).fromCreateDTO(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toResponseDTO(student);
    }
}
