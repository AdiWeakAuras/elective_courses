package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.entity.Student;
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
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
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
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }


}