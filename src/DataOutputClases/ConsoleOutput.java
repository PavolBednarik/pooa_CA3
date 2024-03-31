/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataOutputClases;

import ReportsGenerator.CourseReport;
import ReportsGenerator.LecturerReport;
import ReportsGenerator.StudentReport;
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

    // method to get all information about students reports as consol output
    public static void StudentReport(ArrayList<String> data) throws SQLException {
        //new arraylists with students report information
        StudentReport studentReport = new StudentReport();
        ArrayList<String> studentReportData = studentReport.getPassingStudentReport();
        ArrayList<String> studentReportDataF = studentReport.getFailingStudentReport();
        System.out.println("Student report with passing students");
        System.out.println("Student ID, Student name, Program name, module name, Grade");
        // print all students with passing grade 
        studentReportData.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        System.out.println("Student report with failing students");
        System.out.println("Student ID, Student name, Program name, module name, Grade");
        // print all student with failing grade
        studentReportDataF.forEach(System.out::println);
    }

    // method to get all information about course report as consol output
    public static void CourseReport(ArrayList<String> data) throws SQLException {
        //new arraylist with cours report information
        CourseReport courseReport = new CourseReport();
        ArrayList<String> courseReportData = courseReport.getCourseReport();
        System.out.println("Course report");
        System.out.println("Module name, Program name, Number of student enroled in module, Lecturer name, Room");
        // Print the course report data with for loop
        courseReportData.forEach(System.out::println);
    }
}
