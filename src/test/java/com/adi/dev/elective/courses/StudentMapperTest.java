package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.mapper.StudentMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentMapperTest {

    @Mock
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentMapper studentMapper;

}
