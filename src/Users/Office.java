/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.User.Userrole.OFFICE;

/**
 *
 * @author pavol
 */
public class Office extends User {

    // constructor
    public Office(String username, String password, Userrole role) {
        super(username, password, OFFICE);
    }
}
