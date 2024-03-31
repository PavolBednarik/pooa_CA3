/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.User.Userrole.ADMIN;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class Admin extends User {

    private final Scanner sc;
    private final DatabaseUserTable database;

    public Admin(String username, String password, Userrole role) {
        super(username, password, ADMIN);
        this.sc = new Scanner(System.in);
        this.database = new DatabaseUserTable();
    }

    // add new user method
    public void addNewUser() {
        System.out.println("Enter username:");
        String username = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        System.out.println("Enter role (ADMIN, OFFICE, LECTURER):");
        String roleString = sc.nextLine().toUpperCase();
        Userrole role;
        try {
            role = Userrole.valueOf(roleString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Please enter one of: ADMIN, OFFICE, LECTURER");
            return;
        }
        // adding new user to database
        database.addNewUser(username, password, role);
    }

    // modify user
    public void modifyUser() {
        System.out.print("Enter the username of the user to modify: ");
        String username = sc.nextLine();

        System.out.print("Enter the new username: ");
        String newUsername = sc.nextLine();

        System.out.print("Enter the new password: ");
        String newPassword = sc.nextLine();

        System.out.print("Enter the new role (ADMIN, OFFICE, or LECTURER): ");
        String newroleString = sc.nextLine().toUpperCase();
        Userrole role;
        try {
            role = Userrole.valueOf(newroleString); // user role need to be enum 
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Please enter one of: ADMIN, OFFICE, LECTURER");
            return;
        }
        // updating user in database
        database.modifyUser(username, newUsername, newPassword, role);
    }

    // deleting users
    public void deleteUser() {
        System.out.println("Enter the username of the user to delete:");
        String username = sc.nextLine();
        database.deleteUser(username);
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
            String newPassword = sc.nextLine();
            // Set the new password and update database
            setPassword(newPassword);
            database.updateUserInDatabase(getUsername(), getUsername(), getPassword());
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }

    // method to show all user 
    public void displayAllUsers() {
        // store it in array list
        ArrayList<User> allUsers = database.getAllUsers();
        // checking if its empty
        if (allUsers.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of all users:");
            // checking for all users
            for (User user : allUsers) {
                System.out.println(user.getUsername() + " - " + user.getRole());
            }
        }
    }
}
