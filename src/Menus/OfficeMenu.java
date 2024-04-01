/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Office;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class OfficeMenu {

    Scanner sc;
    Office office;

    public OfficeMenu(Office office) {
        this.office = office;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() throws SQLException {
        int choice;
        do {
            System.out.println("Office Menu:");
            System.out.println("1. Generate Course Report");
            System.out.println("2. Generate Student Report");
            System.out.println("3. Generate Lecturer Report");
            System.out.println("4. Change Password");
            System.out.println("5. Change Username");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    CourseReportOutput report = new CourseReportOutput();
                    report.courseOutputMenu();
                    break;
                case 2:
                    StudentReportOutput report1 = new StudentReportOutput();
                    report1.studentOutputMenu();
                    // studentReportOutput();
                    break;
                case 3:
                    LecturerReportOutput report2 = new LecturerReportOutput();
                    report2.lecOutputMenu();
                    break;
                case 4:
                    office.changePassword();
                    break;
                case 5:
                    office.changeUsername();
                    break;
                case 6:
                    System.out.println("Exiting Office Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 6);
    }
}
