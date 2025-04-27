package labs.lab5.dao;

import labs.lab5.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final String url = "jdbc:h2:~/studentsdb_lab5"; // Шлях до БД
    private final String user = "sa"; // Стандартний користувач H2
    private final String password = ""; // Пароль пустий для H2 за замовчуванням

    public StudentDAO() {
        initializeDatabase();
    }

    // Створення таблиці і вставка тестових даних
    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Створення таблиці
            statement.execute("CREATE TABLE IF NOT EXISTS Students (" +
                    "ID INT PRIMARY KEY," +
                    "Last_Name VARCHAR(255)," +
                    "First_Name VARCHAR(255)," +
                    "Middle_Name VARCHAR(255)," +
                    "Birth_Date DATE," +
                    "Student_ID VARCHAR(50)" +
                    ");");

            // Перевіряємо чи є дані
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Students");
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                // Вставка тестових даних тільки якщо таблиця пуста
                statement.execute("INSERT INTO Students VALUES " +
                        "(1, 'Цибульська', 'Олександра', 'Вадимівна', '2003-02-16', 'S001')," +
                        "(2, 'Петренко', 'Петро', 'Петрович', '2004-05-22', 'S002')," +
                        "(3, 'Сидоренко', 'Іван', 'Іванович', '2003-05-10', 'S003')," +
                        "(4, 'Мельник', 'Василь', 'Васильович', '2003-01-12', 'S004')," +
                        "(5, 'Коваленко', 'Олена', 'Олександрівна', '2004-09-18', 'S005');");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод пошуку студентів по місяцю
    public List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students WHERE MONTH(Birth_Date) = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, month);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("Last_Name"),
                        resultSet.getString("First_Name"),
                        resultSet.getString("Middle_Name"),
                        resultSet.getDate("Birth_Date"),
                        resultSet.getString("Student_ID")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Оновлення даних студента
    public void updateStudent(Student student) {
        String query = "UPDATE Students SET First_Name = ?, Last_Name = ?, Middle_Name = ?, Birth_Date = ?, Student_ID = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, student.getBirthDate());
            statement.setString(5, student.getStudentID());
            statement.setInt(6, student.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student with ID " + student.getId() + " was updated successfully.");
            } else {
                System.out.println("No student found with ID " + student.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
