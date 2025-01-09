import java.util.*;
import java.io.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_PATH = "students.dat";

    // Method to add a student
    public void addStudent(String name, String rollNumber, String grade) {
        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        saveDataToFile();
    }

    // Method to remove a student by roll number
    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
        saveDataToFile();
    }

    // Method to search for a student by roll number
    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null; // return null if student is not found
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.display();
                System.out.println("----------------------------");
            }
        }
    }

    // Method to save student data to file
    private void saveDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data to file.");
        }
    }

    // Method to load student data from file
    private void loadDataFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            students = (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file.");
        }
    }

    // Method to validate input
    public boolean isValidGrade(String grade) {
        return grade.matches("[A-F]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        system.loadDataFromFile();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter Grade (A-F): ");
                    String grade = scanner.nextLine();

                    // Validate Grade
                    if (!system.isValidGrade(grade)) {
                        System.out.println("Invalid grade. Please enter a grade between A-F.");
                        break;
                    }

                    system.addStudent(name, rollNumber, grade);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter Roll Number to remove: ");
                    String rollNumberToRemove = scanner.nextLine();
                    system.removeStudent(rollNumberToRemove);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter Roll Number to search: ");
                    String rollNumberToSearch = scanner.nextLine();
                    Student student = system.searchStudent(rollNumberToSearch);
                    if (student != null) {
                        student.display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Display All Students
                    system.displayAllStudents();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
