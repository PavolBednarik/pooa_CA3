/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.User.Userrole.LECTURER;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class Lecturer extends User {

    private final Scanner sc;
    private final DatabaseUserTable database;
    
    // constructor
    public Lecturer(String username, String password, Userrole role) {
        super(username, password, LECTURER);
        this.sc = new Scanner(System.in);
        this.database = new DatabaseUserTable();
    }
    // method for changing username
    public void changeUsername() {
        // get password form database
        String currentPasswordFromDB = database.getPasswordByUsername(getUsername());
        // Ask for the current password
        System.out.print("Enter current password: ");
        String currentPassword = sc.nextLine();
        // Verify the current password
        if (currentPassword.equals(currentPasswordFromDB)) {
            // Ask for the new username
            System.out.print("Enter new username: ");
            String newUsername = sc.nextLine();
            // Check if the new username matches the current user's username
            if (getUsername().equals(newUsername)) {
                System.out.println("New username cannot be the same as the current username.");
                return;
            }
            // Set the new username and update database
            setUsername(newUsername); 
            database.updateUserInDatabase(getUsername(), newUsername, getPassword());
            System.out.println("Username changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }
    //method for changing password
    public void changePassword() {
        // Ask for the current password
        System.out.print("Enter current password: ");
        String currentPassword = sc.nextLine();
        // Retrieve the current password from the database
        String dbPassword = database.getPasswordByUsername(getUsername());
        // Verify the current password
        if (dbPassword != null && dbPassword.equals(currentPassword)) {
            // Ask for the new password
            System.out.print("Enter new password: ");
            String newPassword = sc.nextLine();
            // Set the new password and update database
            setPassword(newPassword); 
            database.updateUserInDatabase(getUsername(), getUsername(), getPassword());
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }
}