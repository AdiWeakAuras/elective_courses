package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.dto.StudentCreateDTO;
import com.adi.dev.elective.courses.dto.StudentUpdateDTO;
import com.adi.dev.elective.courses.dto.StudentResponseDTO;
import com.adi.dev.elective.courses.entity.Student;
import com.adi.dev.elective.courses.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO createStudent(StudentCreateDTO dto) {

        Student student = studentMapper.fromCreateDTO(dto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return studentMapper.toResponseDTO(student);
    }

    public List<StudentResponseDTO> getStudentByFaculty(String faculty) {
        List<Student> students = studentRepository.findByFaculty(faculty);
        return students.stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getStudentByStudyYear(int studyYear) {
        List<Student> students = studentRepository.findByStudyYear(studyYear);
        return students.stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getStudentByGrade(double grade) {
        List<Student> students = studentRepository.findByGrade(grade);
        return students.stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO updateStudent(Long id, StudentUpdateDTO dto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        studentMapper.updateEntityFromDTO(dto, existingStudent);

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toResponseDTO(updatedStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
}
