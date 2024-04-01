/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Lecturer;
import Users.User;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class LecturerMenu {

    private final Scanner sc;

    Lecturer lecturer;

    public LecturerMenu(Lecturer lecturer) {
        this.sc = new Scanner(System.in);
        this.lecturer = lecturer;
    }

    public void lecturerMenu(User user) {
        int choice;
        do {
            System.out.println("Choose option:");
            System.out.println("1. Generate Lecturer Report");
            System.out.println("2. Change Username");
            System.out.println("3. Change Password");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    LecturerReportOutput reportOutput = new LecturerReportOutput();
                    reportOutput.lecOutputMenu();
                    break;
                case 2:
                    lecturer.changeUsername();
                    break;
                case 3:
                    lecturer.changePassword();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }
}
