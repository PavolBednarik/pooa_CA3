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

}