/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Admin;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class AdminMenu {

    private Scanner sc;
    private Admin admin;

    public AdminMenu(Admin admin) {
        this.admin = admin;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Add new user");
            System.out.println("2. Modify user");
            System.out.println("3. Delete user");
            System.out.println("4. Change own username");
            System.out.println("5. Change own password");
            System.out.println("6. Display all users");
            System.out.println("7. Log out");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.addNewUser();
                    break;
                case 2:
                    admin.modifyUser();
                    break;
                case 3:
                    admin.deleteUser();
                    break;
                case 4:
                    admin.changeUsername();
                    break;
                case 5:
                    admin.changePassword();
                    break;
                case 6:
                    admin.displayAllUsers();
                    break;
                case 7:
                    System.out.println("Returning to Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 7);
    }
}
