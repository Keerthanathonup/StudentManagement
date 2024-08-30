package domain;

import java.util.List;
import java.util.Scanner;

public class StudentEditor {

    public static void editStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student to edit: ");
        String studentName = scanner.nextLine();
        Student studentToEdit = null;

        // Find the student by name
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                studentToEdit = student;
                break;
            }
        }

        if (studentToEdit == null) {
            System.out.println("Student not found.");
            return;
        }

        // Edit student details
        System.out.print("Enter new name (leave blank to keep current name): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            if (!newName.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter a valid name.");
                return;
            }
            studentToEdit.setName(newName);
        }

        System.out.print("Enter new score (leave blank to keep current score): ");
        String newScoreStr = scanner.nextLine();
        if (!newScoreStr.isEmpty()) {
            int newScore;
            try {
                newScore = Integer.parseInt(newScoreStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid score. Please enter a valid score.");
                return;
            }
            if (newScore < 1 || newScore > 100) {
                System.out.println("Invalid score. Please enter a valid score.");
                return;
            }
            studentToEdit.setScore(newScore);
        }

        System.out.println("Student record updated successfully.");
    }
}
