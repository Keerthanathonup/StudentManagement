package domain;

import java.util.List;
import java.util.Scanner;

public class StudentManagementController {
    private final List<Student> students;

    public StudentManagementController(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Scanner scanner) {
        StudentAdder.addStudent(scanner, students);
    }

    public void editStudent(Scanner scanner) {
        StudentEditor.editStudent(scanner, students);
    }

    public void listStudents() {
        StudentLister.listStudents(students);
    }
}
