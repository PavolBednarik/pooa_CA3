/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Lecturer;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a menu specifically for lecturer users, allowing them to generating
 * report and changing their username or password.
 */
public class LecturerMenu {

    private final Scanner sc;

    Lecturer lecturer;

    //Constructs a LecturerMenu with  Lecturer object.
    public LecturerMenu(Lecturer lecturer) {
        this.sc = new Scanner(System.in);
        this.lecturer = lecturer;
    }

    // display lecturer menu
    public void displayMenu() throws SQLException {
        String choice;
        do {
            System.out.println("Choose option:");
            System.out.println("1. Generate Lecturer Report");
            System.out.println("2. Change Username");
            System.out.println("3. Change Password");
            System.out.println("4. Log out");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    // generate lecturer report 
                    LecturerReportOutput reportOutput = new LecturerReportOutput();
                    reportOutput.lecOutputMenu();
                    break;
                case "2":
                    //changing username
                    lecturer.changeUsername();
                    break;
                case "3":
                    //changing pasword
                    lecturer.changePassword();
                    break;
                case "4":
                    System.out.println("Loging out");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
            // loop until they pres 4
        } while (!choice.equals("4"));
    }
}
