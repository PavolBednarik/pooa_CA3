/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms_ca3;

import ReportsGenerator.CourseReport;
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
        
        try {
            CourseReport courseReport = new CourseReport();
            ArrayList<String> courseReportData = courseReport.getCourseReport();
            System.out.println("Course report");
             System.out.println("Module name, Program name, Number of student enroled in module, Lecturer name, Room");
            for (String studentName : courseReportData) {
                System.out.println(studentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
