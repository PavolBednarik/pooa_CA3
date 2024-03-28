/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportsGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pavol
 */
// extending class DBconnector for connecting to my database
public class StudentReport extends DBConnector {

    //creating new method in my student report what generate student with grade above 40 what pass the module
    public ArrayList<String> getPassingStudentReport() throws SQLException {
        ArrayList<String> allData = new ArrayList<>();
        //mySQL query for student report with grade over 40
        String query = "SELECT "
                + "s.student_id, "
                + "s.student_name, "
                + "c.program_name, "
                + "c.module_name, "
                + "g.grade "
                + "FROM "
                + "student s "
                + "JOIN "
                + "enrolments e ON s.student_id = e.student_id "
                + "JOIN "
                + "grades g ON s.student_id = g.student_id "
                + "JOIN "
                + "course c ON e.course_id = c.course_id "
                + "WHERE "
                + "g.grade > 39";
        // try and chatch for connection to mySQL
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // looping through database to get all information according my query
            while (rs.next()) {
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String programme = rs.getString("program_name");
                String module = rs.getString("module_name");
                String completedModules = rs.getString("grade");
                //output seperated by dash
                allData.add(studentId + " - " + studentName + " - " + programme + " - " + module + " - " + completedModules);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }

    // same report but in this case it will show all student what grade is less than 40 and failing module
    public ArrayList<String> getFailingStudentReport() throws SQLException {
        ArrayList<String> allData = new ArrayList<>();
        String query = "SELECT "
                + "s.student_id, "
                + "s.student_name, "
                + "c.program_name, "
                + "c.module_name, "
                + "g.grade "
                + "FROM "
                + "student s "
                + "JOIN "
                + "enrolments e ON s.student_id = e.student_id "
                + "JOIN "
                + "grades g ON s.student_id = g.student_id "
                + "JOIN "
                + "course c ON e.course_id = c.course_id "
                + "WHERE "
                + "g.grade < 40";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String programme = rs.getString("program_name");
                String module = rs.getString("module_name");
                String completedModules = rs.getString("grade");
                allData.add(studentId + " - " + studentName + " - " + programme + " - " + module + " - " + completedModules);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
}
