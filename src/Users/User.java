/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import ReportsGenerator.DBConnector;

/**
 *
 * @author pavol
 */
// extention for database conector 
public class User extends DBConnector {

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

}
