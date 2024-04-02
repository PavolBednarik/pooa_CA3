/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import ReportsGenerator.DBConnector;
import Users.User.Userrole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pavol
 */
public class DatabaseUserTable extends DBConnector {

    // i didnt implement in my database user table so we need to create table with users
    public void createTable(String Users) {
        String query = "CREATE TABLE users ("
                + "username VARCHAR(50) UNIQUE,"
                + "password VARCHAR(50),"
                + "role ENUM('ADMIN', 'OFFICE', 'LECTURER')"
                + ")";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            System.out.println("Table sucessfully created");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method with sql to add new user 
    public void addNewUser(String username, String password, Userrole role) {
        // mysql query 
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try ( Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD); // used prepared statment for better security 
                  PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role.toString());// converting enum to string
            pstmt.executeUpdate();
            System.out.println("New user added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add new user to the database.");
        }
    }   // methos to modify users

    public void modifyUser(String username, String newUsername, String newPassword, Userrole role) {
        String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE username = ?";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            // used prepared statment for better security 
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newPassword);
            pstmt.setString(3, role.toString());// converting enum to string
            pstmt.setString(4, username);
            //exetute update 
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method for deleting users by username
    public void deleteUser(String username) {
        String query = "DELETE FROM users WHERE username = ?";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to retrive pasword from database 
    public String getPasswordByUsername(String username) {
        String query = "SELECT password FROM users WHERE username = ?";
        // inicialaying pasword
        String password = null;
        // conection to database
        try ( Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);  PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            // checking for column password
            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    // method to update user in database for changin username
    public void updateUserInDatabase(String oldUsername, String newUsername, String newPassword) {
        String query = "UPDATE users SET username = ?, password = ? WHERE username = ?";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newPassword);
            pstmt.setString(3, oldUsername);
            pstmt.executeUpdate();
            conn.close();
            System.out.println("User information updated successfully in the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update user information in the database.");
        }
    }

    // method to check all users
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        String query = "SELECT * FROM users";

        try ( Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);  PreparedStatement pstmt = conn.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {
            // loop to add them in array list
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                Userrole userRole = Userrole.valueOf(role);
                User user = new User(username, password, userRole);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }

    public User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";
        try ( Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);  PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String fetchedUsername = rs.getString("username");
                    String fetchedPassword = rs.getString("password");
                    String fetchedRoleStr = rs.getString("role");
                    Userrole fetchedRole = Userrole.valueOf(fetchedRoleStr);
                    switch (fetchedRole) {
                        case ADMIN:
                            user = new Admin(fetchedUsername, fetchedPassword, fetchedRole);
                            break;
                        case OFFICE:
                            user = new Office(fetchedUsername, fetchedPassword, fetchedRole);
                            break;
                        case LECTURER:
                            user = new Lecturer(fetchedUsername, fetchedPassword, fetchedRole);
                            break;
                        default:
                            System.out.println("Unknown user role: " + fetchedRoleStr);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve user information from the database.");
        }
        return user;
    }
}
