package apps;

import domain.StudentManagementController;
import domain.StudentFileManager;
import domain.StudentDisplay;
import domain.Student;

import java.util.List;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = StudentFileManager.loadStudentsFromFile(); // Load students from file
        StudentManagementController controller = new StudentManagementController(students);

        int choice;

        do {
            StudentDisplay.showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    controller.addStudent(scanner);
                    break;
                case 2:
                    controller.editStudent(scanner);
                    break;
                case 3:
                    controller.listStudents();
                    break;
                case 4:
                    StudentFileManager.saveStudentsToFile(students); // Save students to file
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (choice != 4);
    }
}
