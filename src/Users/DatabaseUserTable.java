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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pavol
 */
public class DatabaseUserTable extends DBConnector {

    // i didnt implement in my database user table so we need to create table with users
    public void createTable(String Users) {
        String sql = "CREATE TABLE users ("
                + "username VARCHAR(50) UNIQUE,"
                + "password VARCHAR(50),"
                + "role ENUM('ADMIN', 'OFFICE', 'LECTURER')"
                + ")";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table sucessfully created");
            conn.close();
        } catch (Exception e) {
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

        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
