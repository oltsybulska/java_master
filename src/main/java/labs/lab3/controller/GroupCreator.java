package labs.lab3.controller;

import labs.lab3.model.Group;
import labs.lab3.model.Human;
import labs.lab3.model.Student;


public class GroupCreator {
    private StudentCreator studentCreator;


    public GroupCreator() {
        this.studentCreator = new StudentCreator();
    }


    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }


    public void addStudentToGroup(Group group, Student student) {
        group.addStudent(student);
    }
}