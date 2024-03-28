/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms_ca3;

import ReportsGenerator.CourseReport;
import ReportsGenerator.LecturerReport;
import ReportsGenerator.StudentReport;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pavol
 */
public class CMS_CA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // testing course report generator
//        try {
//            CourseReport courseReport = new CourseReport();
//            ArrayList<String> courseReportData = courseReport.getCourseReport();
//            System.out.println("Course report");
//             System.out.println("Module name, Program name, Number of student enroled in module, Lecturer name, Room");
//            for (String studentName : courseReportData) {
//                System.out.println(studentName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            StudentReport studentReport = new StudentReport();
//            ArrayList<String> studentReportData = studentReport.getPassingStudentReport();
//            System.out.println("Student report with passing student");
//            System.out.println("Student ID, Student name, Program name, module name, Grade");
//            for (String studentName : studentReportData) {
//                System.out.println(studentName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            StudentReport studentReport = new StudentReport();
//            ArrayList<String> studentReportData = studentReport.getFailingStudentReport();
//            System.out.println("Student report with failing student");
//            System.out.println("Student ID, Student name, Program name, module name, Grade");
//            for (String studentName : studentReportData) {
//                System.out.println(studentName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            LecturerReport lecturerReport = new LecturerReport();
            ArrayList<String> lecturerReportData = lecturerReport.getLecturerReport();
            System.out.println("Lecturer report");
            System.out.println("Lecturer name, Role, Module name, Number of students, Qualification");
            for (String report : lecturerReportData) {
                System.out.println(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
