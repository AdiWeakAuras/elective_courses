package com.adi.dev.elective.courses.dto;

public class StudentUpdateDTO {
    private double grade;
    private int studyYear;

    public StudentUpdateDTO() {}

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }
}
