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
public class CourseReport extends DBConnector {
// creating method to get course report and store it in arraylist

    public ArrayList<String> getCourseReport() throws SQLException {
        ArrayList<String> allData = new ArrayList<>();
        //query for selecting data from different tables to get course report
        String query = "SELECT "
                + "c.module_name, "
                + "c.program_name, "
                + "c.module_room, "
                + "COUNT(e.enrolment_id) AS num_of_student, "
                + "l.lecturer_name "
                + "FROM "
                + "course c "
                + "JOIN "
                + "enrolments e ON c.course_id = e.course_id "
                + "JOIN "
                + "feedback f ON c.course_id = f.course_id "
                + "JOIN "
                + "lecturer l ON f.lecturer_id = l.lecturer_id "
                + "GROUP BY "
                + "c.course_id, c.module_name, c.program_name, c.module_room, l.lecturer_name";
        // try and catch in case connection fail
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // loop through my query to get all data avialable 
            while (rs.next()) {
                String name = rs.getString("module_name");
                String program = rs.getString("program_name");
                int student = rs.getInt("num_of_student");
                String lecturer = rs.getString("lecturer_name");
                String moduleRoom = rs.getString("module_room");
                //output using dashes between columns
                allData.add(name + " - " + program + " - " + student + " - " + lecturer + " - " + moduleRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }

    // another method to generate course report instead of dashes are comas so it will be used for csv file output
    public ArrayList<String> getCourseReportcsv() throws SQLException {
        ArrayList<String> allData = new ArrayList<>();
        String query = "SELECT "
                + "c.module_name, "
                + "c.program_name, "
                + "c.module_room, "
                + "COUNT(e.enrolment_id) AS num_of_student, "
                + "l.lecturer_name "
                + "FROM "
                + "course c "
                + "JOIN "
                + "enrolments e ON c.course_id = e.course_id "
                + "JOIN "
                + "feedback f ON c.course_id = f.course_id "
                + "JOIN "
                + "lecturer l ON f.lecturer_id = l.lecturer_id "
                + "GROUP BY "
                + "c.course_id, c.module_name, c.program_name, c.module_room, l.lecturer_name";
        try {
            Connection conn = DriverManager.getConnection(DB_URL + "/CMS", USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("module_name");
                String program = rs.getString("program_name");
                int student = rs.getInt("num_of_student");
                String lecturer = rs.getString("lecturer_name");
                String moduleRoom = rs.getString("module_room");
                allData.add(name + "," + program + "," + student + "," + lecturer + "," + moduleRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
}
