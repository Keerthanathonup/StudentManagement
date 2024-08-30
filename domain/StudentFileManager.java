package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileManager {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    public static List<Student> loadStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // Split the line by comma
                    String[] parts = line.split(",");
                    
                    // Extract the name part after "Name: "
                    String namePart = parts[0].split(":")[1].trim();
                    
                    // Extract the score part after "Score: "
                    String scorePart = parts[1].split(":")[1].trim();
                    
                    // Convert scorePart to an integer
                    int score = Integer.parseInt(scorePart);
                    
                    // Add the student to the list
                    students.add(new Student(namePart, score));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing student data found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing student score: " + e.getMessage());
        }
        return students;
    }
}
