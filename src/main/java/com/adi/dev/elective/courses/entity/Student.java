package com.adi.dev.elective.courses.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String fullName;
    private double grade;
    private int studyYear;
    private String faculty;

    protected Student() {}

    public Student(String fullName, double grade, int studyYear, String faculty) {
        this.fullName = fullName;
        this.grade = grade;
        this.studyYear = studyYear;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", full_name='" + fullName + '\'' +
                ", grade=" + grade +
                ", study_year=" + studyYear +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGrade() {
        return grade;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
