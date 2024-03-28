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
// extendng DBconnector 
public class LecturerReport extends DBConnector {

    // method to get lecturer report 
    public ArrayList<String> getLecturerReport() throws SQLException {
        // storing my report in arraylist 
        ArrayList<String> allData = new ArrayList<>();
        //query for MySQL to get all data needed
        String query = "SELECT "
                + "l.lecturer_name, "
                + "l.lecturel_position, "
                + "l.qualification, "
                + "c.module_name, "
                + "COUNT(e.enrolment_id) AS num_of_student "
                + "FROM "
                + "lecturer l "
                + "JOIN "
                + "feedback f ON l.lecturer_id = f.lecturer_id "
                + "JOIN "
                + "enrolments e ON f.course_id = e.course_id "
                + "JOIN "
                + "course c ON e.course_id = c.course_id "
                + "GROUP BY "
                + "l.lecturer_id, c.module_name";
        // try and catch connection of mySQl
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // looping trough all database 
            while (rs.next()) {
                String lecturer = rs.getString("lecturer_name");
                String role = rs.getString("lecturel_position");
                String module = rs.getString("module_name");
                int student = rs.getInt("num_of_student");
                String qualification = rs.getString("qualification");
                // adding data to my arraylist separated by dash
                allData.add(lecturer + " - " + role + " - " + module + " - " + student + " - " + qualification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
    // same method for Lecturer report with output for csv file 
    public ArrayList<String> getLecturerReportcsv() throws SQLException {
        ArrayList<String> allData = new ArrayList<>();
        String query = "SELECT "
                + "l.lecturer_name, "
                + "l.lecturel_position, "
                + "l.qualification, "
                + "c.module_name, "
                + "COUNT(e.enrolment_id) AS num_of_student "
                + "FROM "
                + "lecturer l "
                + "JOIN "
                + "feedback f ON l.lecturer_id = f.lecturer_id "
                + "JOIN "
                + "enrolments e ON f.course_id = e.course_id "
                + "JOIN "
                + "course c ON e.course_id = c.course_id "
                + "GROUP BY "
                + "l.lecturer_id, c.module_name";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String lecturer = rs.getString("lecturer_name");
                String role = rs.getString("lecturel_position");
                String module = rs.getString("module_name");
                int student = rs.getInt("num_of_student");
                String qualification = rs.getString("qualification");
                allData.add(lecturer + "," + role + "," + module + "," + student + "," + qualification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
}
