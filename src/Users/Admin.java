/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.User.Userrole.ADMIN;
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
}
