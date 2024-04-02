/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import ReportsGenerator.DBConnector;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
// extention for database conector 
public class User extends DBConnector {
    private Scanner sc;
    private DatabaseUserTable database;
    private String username;
    private String password;
    private Userrole role;

    // enum for userrole
    public enum Userrole {
        ADMIN,
        OFFICE,
        LECTURER;
    }
    // consturctor
    public User(String username, String password, Userrole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.sc = new Scanner(System.in); 
        this.database = new DatabaseUserTable();
    }
    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Userrole getRole() {
        return role;
    }

    public void setRole(Userrole role) {
        this.role = role;
    }
     // method to change username
    public void changeUsername() {
        // geting username from database
        String currentPasswordFromDB = database.getPasswordByUsername(getUsername());
        // Ask for the current password
        System.out.print("Enter current password: ");
        String currentPassword = sc.nextLine();
        // Verify the current password
        if (currentPassword.equals(currentPasswordFromDB)) {
            System.out.print("Enter new username: ");
            String newUsername = sc.nextLine().trim();
            // Check if the new username matches the current user's username
            if (getUsername().equals(newUsername)) {
                System.out.println("New username cannot be the same as the current username.");
                return;
            }
             String oldUsername = getUsername();
            // Set the new username and update database
            setUsername(newUsername);
            database.updateUserInDatabase(oldUsername, newUsername, getPassword());
            System.out.println("Username changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }

    // method for changing password
    public void changePassword() {
        System.out.print("Enter current password: ");
        String currentPassword = sc.nextLine();
        // Retrieve the current password from the database
        String dbPassword = database.getPasswordByUsername(getUsername());
        // Verify the current password
        if (dbPassword != null && dbPassword.equals(currentPassword)) {
            // Ask for the new password
            System.out.print("Enter new password: ");
            String newPassword = sc.nextLine().trim();
            // Set the new password and update database
            setPassword(newPassword);
            database.updateUserInDatabase(getUsername(), getUsername(), getPassword());
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }
}
