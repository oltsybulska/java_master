package labs.lab5.model;

import java.sql.Date;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private String studentID;

    public Student(int id, String lastName, String firstName, String middleName, Date birthDate, String studentID) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.studentID = studentID;
    }

    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public Date getBirthDate() { return birthDate; }
    public String getStudentID() { return studentID; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
