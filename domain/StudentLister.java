package domain;

import java.util.List;

public class StudentLister {

    public static void listStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
