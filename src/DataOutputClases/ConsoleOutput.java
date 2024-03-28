/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataOutputClases;

import ReportsGenerator.LecturerReport;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pavol
 */
public class ConsoleOutput {
    // method to get all information about lecturer report as consol output
    public static void LecturerReport(ArrayList<String> data) throws SQLException {
        //new arraylist with lecturer report information
        LecturerReport lecturerReport = new LecturerReport();
        ArrayList<String> lecturerReportData = lecturerReport.getLecturerReport();
        System.out.println("Lecturer report");
        System.out.println("Lecturer name, Role, Module name, Number of students, Qualification");
        // Print the lecturer report data sugested by netbean console
        lecturerReportData.forEach(System.out::println);

    }
}
