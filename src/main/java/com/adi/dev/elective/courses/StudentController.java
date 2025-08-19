package com.adi.dev.elective.courses;

import org.springframework.web.bind.annotation.*;
import java.util.List;


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

}