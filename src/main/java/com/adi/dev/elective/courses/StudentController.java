package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(201).body(createdStudent);
    }

    // /students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // /students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    // /students/{id}/search?name=Frodo Baggins
    @GetMapping("/search")
    public List<Student> getStudentByFullName(@RequestParam String name){
        return studentService.getStudentByFullName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}