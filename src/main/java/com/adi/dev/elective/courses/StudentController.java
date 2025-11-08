package com.adi.dev.elective.courses;

import com.adi.dev.elective.courses.dto.StudentCreateDTO;
import com.adi.dev.elective.courses.dto.StudentUpdateDTO;
import com.adi.dev.elective.courses.dto.StudentResponseDTO;
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

    // Create a new student
    @PostMapping("")
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentCreateDTO dto) {
        StudentResponseDTO createdStudent = studentService.createStudent(dto);
        return ResponseEntity.status(201).body(createdStudent);
    }

    // Get all students
    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Search students by full name
    @GetMapping("/search")
    public List<StudentResponseDTO> getStudentByFullName(@RequestParam String name) {
        return studentService.getStudentByFullName(name);
    }

    // Update existing student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentUpdateDTO dto) {
        StudentResponseDTO updatedStudent = studentService.updateStudent(id, dto);
        return ResponseEntity.ok(updatedStudent); // 200 OK
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
