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
        String username = sc.nextLine().trim();

        System.out.println("Enter password:");
        String password = sc.nextLine().trim();

        System.out.println("Enter role (ADMIN, OFFICE, LECTURER):");
        String roleString = sc.nextLine().trim().toUpperCase();
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
        String username = sc.nextLine().trim();

        System.out.print("Enter the new username: ");
        String newUsername = sc.nextLine().trim();

        System.out.print("Enter the new password: ");
        String newPassword = sc.nextLine().trim();

        System.out.print("Enter the new role (ADMIN, OFFICE, or LECTURER): ");
        String newroleString = sc.nextLine().trim().toUpperCase();
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
        String username = sc.nextLine().trim();
        database.deleteUser(username);
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
