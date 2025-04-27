package labs.lab3.controller;

import labs.lab3.model.Student;
import labs.lab3.model.Sex;


public class StudentCreator {
    private HumanCreator humanCreator;


    public StudentCreator() {
        this.humanCreator = new HumanCreator();
    }


    public Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}