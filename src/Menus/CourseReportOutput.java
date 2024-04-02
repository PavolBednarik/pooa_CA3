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
 * Handles the display of course reports through various output formats.
 * Provides a menu to the user for selecting the output format of the course
 * report, including console display, CSV file, and text file.
 */
public class CourseReportOutput {

    private Scanner sc;

    public CourseReportOutput() {
        sc = new Scanner(System.in);
    }

    // menu for course output
    public void courseOutputMenu() throws SQLException {
        String choice;
        do {
            System.out.println("Choose output option:");
            System.out.println("1. Output to Console");
            System.out.println("2. Output to CSV File");
            System.out.println("3. Output to Text File");
            System.out.println("4. Exit course report menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().trim();
            // geting course report data
            CourseReport courseReport = new CourseReport();
            ArrayList<String> courseReportData = courseReport.getCourseReport();
            ArrayList<String> courseReportDatacsv = courseReport.getCourseReportcsv();
            switch (choice) {
                case "1":
                    // Output the course report to the console
                    ConsoleOutput.CourseReport(courseReportData);
                    break;
                case "2":
                    // Output the course report to a CSV file
                    CSVFileOutput write = new CSVFileOutput();
                    write.outputToCSVFile(courseReportDatacsv);
                    break;
                case "3":
                    // Output the course report to a text file
                    TextFileOutput writetxt = new TextFileOutput();
                    writetxt.outputToTextFile(courseReportData);
                    break;
                case "4":
                    System.out.println("Exiting menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (!choice.equals("4"));
    }
}
