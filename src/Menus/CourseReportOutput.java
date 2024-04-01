/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import DataOutputClases.CSVFileOutput;
import DataOutputClases.ConsoleOutput;
import DataOutputClases.TextFileOutput;
import ReportsGenerator.CourseReport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class CourseReportOutput {
 
     private Scanner sc;

    public CourseReportOutput() {
        sc = new Scanner(System.in);
    }
    // menu for course output
    public void courseOutputMenu() {
        int choice;
        do {
            System.out.println("Choose output option:");
            System.out.println("1. Output to Console");
            System.out.println("2. Output to CSV File");
            System.out.println("3. Output to Text File");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    outputToConsole();
                    break;
                case 2:
                    outputToCSVFile();
                    break;
                case 3:
                    outputToTextFile();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void outputToConsole() {
        try {
            CourseReport courseReport = new CourseReport();
            ArrayList<String> courseReportData = courseReport.getCourseReport();
            ConsoleOutput.CourseReport(courseReportData);
        } catch (SQLException e) {
        }
    }

    private void outputToCSVFile() {
        try {
            CourseReport courseReport = new CourseReport();
            ArrayList<String> courseReportData = courseReport.getCourseReportcsv();
            CSVFileOutput write = new CSVFileOutput();
            write.outputToCSVFile(courseReportData);
        } catch (SQLException e) {
        }
    }

    private void outputToTextFile() {
        try {
            CourseReport courseReport = new CourseReport();
            ArrayList<String> courseReportData = courseReport.getCourseReport();
            TextFileOutput write = new TextFileOutput();
            write.outputToTextFile(courseReportData);
        } catch (SQLException e) {
        }
    }
}