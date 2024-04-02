/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Users.Admin;
import java.util.Scanner;

/**
 * Represents the admin menu This class is responsible for displaying the admin
 * actions menu and handling user inputs to execute various administrative
 * functions such as adding, modifying, and deleting users,changing username and
 * password
 */
public class AdminMenu {

    private Scanner sc;
    private Admin admin;

    // constructor for admin menu with admin object
    public AdminMenu(Admin admin) {
        this.admin = admin;
        this.sc = new Scanner(System.in);
    }

    /**
     * Displays the admin menu and processes user choices. This method
     * repeatedly displays the menu and executes the selected action until the
     * user decides to log out by choosing option 7.
     */
    public void displayMenu() {
        String choice;
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
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    admin.addNewUser();
                    break;
                case "2":
                    admin.modifyUser();
                    break;
                case "3":
                    admin.deleteUser();
                    break;
                case "4":
                    admin.changeUsername();
                    break;
                case "5":
                    admin.changePassword();
                    break;
                case "6":
                    admin.displayAllUsers();
                    break;
                case "7":
                    System.out.println("Returning to log in page");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        } while (!choice.equals("7"));
    }
}
