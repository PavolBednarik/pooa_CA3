/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.User.Userrole.LECTURER;

/**
 *
 * @author pavol
 */
public class Lecturer extends User {

    // constructor
    public Lecturer(String username, String password, Userrole role) {
        super(username, password, LECTURER);

    }

}
