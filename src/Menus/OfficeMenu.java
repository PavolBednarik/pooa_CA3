/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Office;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Menu for office users, providing various options for generating reports,
 * changing user username and password, and exiting the menu.
 */
public class OfficeMenu {

    Scanner sc;
    Office office;
//Constructs an OfficeMenu with the Office user.

    public OfficeMenu(Office office) {
        this.office = office;
        this.sc = new Scanner(System.in);
    }

    // display menu with various choices
    public void displayMenu() throws SQLException {
        String choice;
        do {
            System.out.println("Office Menu:");
            System.out.println("1. Generate Course Report");
            System.out.println("2. Generate Student Report");
            System.out.println("3. Generate Lecturer Report");
            System.out.println("4. Change Password");
            System.out.println("5. Change Username");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().trim();
// Process the choice
            switch (choice) {
                case "1":
                    // Generate and display the course report menu
                    CourseReportOutput report = new CourseReportOutput();
                    report.courseOutputMenu();
                    break;
                case "2":
                    // Generate and display the student report menu
                    StudentReportOutput report1 = new StudentReportOutput();
                    report1.studentOutputMenu();
                    break;
                case "3":
                    // Generate and display the lecturer report menu
                    LecturerReportOutput report2 = new LecturerReportOutput();
                    report2.lecOutputMenu();
                    break;
                case "4":
                    // change password
                    office.changePassword();
                    break;
                case "5":
                    // change username
                    office.changeUsername();
                    break;
                case "6":
                    System.out.println("Exiting Office Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (!choice.equals("6"));
    }
}
