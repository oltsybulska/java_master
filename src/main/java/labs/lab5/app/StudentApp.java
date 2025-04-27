package labs.lab5.app;

import labs.lab5.dao.StudentDAO;
import labs.lab5.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        List<Student> students = studentDAO.getStudentsByMonth(month);

        if (students.isEmpty()) {
            System.out.println("Студентів, народжених у цьому місяці, не знайдено.");
        } else {
            System.out.printf("%-5s %-15s %-15s %-20s %-15s %-15s%n", "ID", "Прізвище", "Ім'я", "По-батькові", "Дата нар.", "Номер залікової книжки");
            System.out.println("------------------------------------------------------------------------------------------");

            for (Student student : students) {
                System.out.printf("%-5d %-15s %-15s %-20s %-15s %-15s%n",
                        student.getId(),
                        student.getLastName(),
                        student.getFirstName(),
                        student.getMiddleName(),
                        student.getBirthDate(),
                        student.getStudentID());
            }
        }
    }
}
