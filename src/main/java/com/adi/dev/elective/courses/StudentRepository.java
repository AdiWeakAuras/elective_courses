package com.adi.dev.elective.courses;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long>{

    List<Student> findByFullName(String full_name);
    Optional<Student> findById(Long id);
}
