package com.adi.dev.elective.courses;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    // /students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // /students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found."));
    }

    // /students/{id}/search?name=Frodo Baggins
    @GetMapping("/search")
    public List<Student> getStudentByFullName(@RequestParam String name){
        return studentRepository.findByFullName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);

    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found."));
        existingStudent.setFullName(student.getFullName());
        existingStudent.setId(student.getId());
        existingStudent.setGrade(student.getGrade());
        existingStudent.setFaculty(student.getFaculty());
        existingStudent.setStudyYear(student.getStudyYear());
        return studentRepository.save(existingStudent);

    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}