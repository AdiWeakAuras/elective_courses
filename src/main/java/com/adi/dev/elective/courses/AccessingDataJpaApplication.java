package com.adi.dev.elective.courses;
import com.adi.dev.elective.courses.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args){
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean

    public CommandLineRunner demo(StudentRepository repository){
        return (args) ->{
            // save a few customers
            repository.save(new Student("Bilbo Baggins", 8.23, 2, "AC"));
            repository.save(new Student("Frodo Baggins", 7.51, 1, "ETC"));
            repository.save(new Student("Samwise Gamgee", 6.22, 3, "AC"));
            repository.save(new Student("Peregrin Took", 8.98, 5, "FEEA"));
            repository.save(new Student("Meriadoc Brandy", 9.55, 1, "FMI"));

            // fetch all customers
            log.info("Students found with findAll");
            log.info("---------------------------");
            repository.findAll().forEach(student ->{
                log.info(student.toString());
            });
            log.info("");

            // fetch an individual customer by ID
            Optional<Student> student = repository.findById(1L);
            log.info("Student found with findById(1L)");
            log.info("------------------------------");
            log.info(student.toString());
            log.info("");

            // fetch customers by last name
            log.info("Student found with findByFullName('Frodo Baggins')");
            log.info("--------------------------------------------------");
            repository.findByFullName("Frodo Baggins").forEach(frodo -> {
                log.info(frodo.toString());
            });
            log.info("");
        };
    }
}
