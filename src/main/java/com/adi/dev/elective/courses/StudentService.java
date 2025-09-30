package com.adi.dev.elective.courses;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found."));
    }

    public List<Student> getStudentByFullName(String name){
        return studentRepository.findByFullName(name);
    }

    public Student updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found."));
        existingStudent.setFullName(student.getFullName());
        existingStudent.setId(student.getId());
        existingStudent.setGrade(student.getGrade());
        existingStudent.setFaculty(student.getFaculty());
        existingStudent.setStudyYear(student.getStudyYear());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
