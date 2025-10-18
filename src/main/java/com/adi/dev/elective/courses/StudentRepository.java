package com.adi.dev.elective.courses;
import java.util.List;

import com.adi.dev.elective.courses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFullName(String full_name);
}
