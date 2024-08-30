package domain;

import java.util.List;
import java.util.Scanner;

public class StudentAdder {

    public static void addStudent(Scanner scanner, List<Student> students) {
        String studentName;
        int studentScore;

        do {
            System.out.print("Enter Student name: ");
            studentName = scanner.nextLine();
            if (!studentName.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter a valid name.");
            }
        } while (!studentName.matches("[a-zA-Z ]+"));

        do {
            System.out.print("Enter Student score: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid score. Please enter a valid score.");
                System.out.print("Enter Student score: ");
                scanner.next(); // Consume invalid input
            }
            studentScore = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (studentScore < 1 || studentScore > 100) {
                System.out.println("Invalid score. Please enter a valid score.");
            }
        } while (studentScore < 1 || studentScore > 100);

        students.add(new Student(studentName, studentScore));
        System.out.println("Student record added successfully.");
    }
}
