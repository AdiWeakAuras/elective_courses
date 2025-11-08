package com.adi.dev.elective.courses;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Student with id "+id+" not found");
    }
}
