/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms_ca3;

import Menus.AdminMenu;
import Menus.LecturerMenu;
import Menus.OfficeMenu;
import Users.Admin;
import Users.DatabaseUserTable;
import Users.Lecturer;
import Users.Office;
import Users.User;
import static Users.User.Userrole.ADMIN;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class CMS_CA3 {

    /**
     * @param args the command line arguments
     */
    // https://github.com/PavolBednarik/pooa_CA3.git
    public static void main(String[] args) throws SQLException {

        // I didnt include users table in my database so this code need to be run first to create table and first user  
//         DatabaseUserTable table = new DatabaseUserTable();
//         table.createTable("users");
//         table.addNewUser("admin", "java", ADMIN);
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;
        
        while (!exitProgram) {
        User currentUser = authenticateUser(sc);

        if (currentUser != null) {
            displayMainMenu(currentUser);
            System.out.println("Logged out successfully.");
            System.out.println("Do you want to log in as a different user? (yes/no)");
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.equals("no")) {
                exitProgram = true;
            }
        } else {
            System.out.println("Login failed. Exiting program.");
            exitProgram = true; 
        }
    }

    System.out.println("Exiting program.");
    sc.close();
}

    private static User authenticateUser(Scanner sc) {
        // Ask user for username and password
        System.out.println("Enter username: ");
        String username = sc.nextLine().trim();
        System.out.println("Enter password: ");
        String password = sc.nextLine().trim();

        // Query the database to retrieve user information
        DatabaseUserTable database = new DatabaseUserTable();
        User user = database.getUserByUsername(username);

        // Validate the credentials
        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            System.out.println("Authentication successful. Welcome, " + user.getUsername() + "!");
            return user;
        } else {
            // Authentication failed
            System.out.println("Authentication failed. Please check your username and password.");
            return null;
        }
    }

    private static void displayMainMenu(User currentUser) throws SQLException {
        // Check if currentUser is null or not an instance of Admin, Office, or Lecturer
        if (currentUser == null) {
            System.out.println("Invalid user.");
            return;
        }

        // Display the main menu based on the user's role
        switch (currentUser.getRole()) {
            case ADMIN:
                if (currentUser instanceof Admin) {
                    Admin admin = (Admin) currentUser;
                    AdminMenu adminMenu = new AdminMenu(admin);
                    adminMenu.displayMenu();
                } else {
                    System.out.println("Invalid user type for Admin role.");
                }
                break;
            case OFFICE:
                if (currentUser instanceof Office) {
                    Office office = (Office) currentUser;
                    OfficeMenu officeMenu = new OfficeMenu(office);
                    officeMenu.displayMenu();
                } else {
                    System.out.println("Invalid user type for Office role.");
                }
                break;
            case LECTURER:
                if (currentUser instanceof Lecturer) {
                    Lecturer lecturer = (Lecturer) currentUser;
                    LecturerMenu lecturerMenu = new LecturerMenu(lecturer);
                    lecturerMenu.displayMenu();
                } else {
                    System.out.println("Invalid user type for Lecturer role.");
                }
                break;
            default:
                System.out.println("Invalid user role.");
        }
    }
}
