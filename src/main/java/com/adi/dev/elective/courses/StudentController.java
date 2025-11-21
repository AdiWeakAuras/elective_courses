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

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) String faculty,
                                         @RequestParam(required = false) Integer studyYear,
                                         @RequestParam(required = false) Double grade) {
        if (id != null) {
            StudentResponseDTO student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } else if (faculty != null) {
            List<StudentResponseDTO> students = studentService.getStudentByFaculty(faculty);
            return ResponseEntity.ok(students);
        } else if (studyYear != null) {
            List<StudentResponseDTO> students = studentService.getStudentByStudyYear(studyYear);
            return ResponseEntity.ok(students);
        } else if (grade != null) {
            List<StudentResponseDTO> students = studentService.getStudentByGrade(grade);
            return ResponseEntity.ok(students);
        } else {
            List<StudentResponseDTO> students = studentService.getAllStudents();
            return ResponseEntity.ok(students);
        }
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
