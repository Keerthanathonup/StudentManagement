
Student Management System

This project is a simple Java-based console application that allows users to manage student records. It provides functionalities to add, edit, list, and store student
information. 

Project Structure

apps package:
StudentApp: Contains the main method, which handles the main menu and user interaction. It invokes methods for adding, editing, listing, and saving students.

domain package:
StudentManagementController: Controls the flow of data and calls the respective methods in different classes based on user actions.
StudentAdd: Handles the addition of new students to the ArrayList and ensures validation of input data.
StudentEdit: Allows modification of existing student records.
StudentList: Manages listing of all student records stored in the system.
StudentFileManager: Manages saving student records to a file (students.txt) and loading them when the application starts.

resources:
students.txt: A text file where student data is saved. The file stores records in the format: Name: <name>, Score: <score>.

Features
Add Student: Allows the user to add a new student by entering their name and score, with validation to ensure correct input.
Edit Student: Lets the user edit the details of an existing student.
List Students: Displays a list of all students currently stored.
Persistent Storage: Student records are saved in a text file, enabling data persistence between sessions.
