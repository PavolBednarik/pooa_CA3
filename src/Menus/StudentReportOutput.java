/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import DataOutputClases.CSVFileOutput;
import DataOutputClases.ConsoleOutput;
import DataOutputClases.TextFileOutput;
import ReportsGenerator.StudentReport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Output of student reports through various formats. This class provides the
 * functionality to display a menu for choosing output format for student
 * reports, including console, CSV file, and text file outputs,
 */
public class StudentReportOutput {

    private Scanner sc;

    public StudentReportOutput() {
        sc = new Scanner(System.in);
    }

    // student output menu display 
    public void studentOutputMenu() throws SQLException {
        String choice;
        do {
            System.out.println("Choose output option:");
            System.out.println("1. Output to Console");
            System.out.println("2. Output to CSV File");
            System.out.println("3. Output to Text File");
            System.out.println("4. Exit course report menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().trim();
            // Fetch the student report data in preparation for output
            StudentReport studentReport = new StudentReport();
            ArrayList<String> studentReportData = studentReport.getPassingStudentReport();
            ArrayList<String> studentReportDatacsv = studentReport.getPassingStudentReportcsv();
            switch (choice) {
                case "1":
                    // Output the student report to the console
                    ConsoleOutput.StudentReport(studentReportData);
                    break;
                case "2":
                    // Output the student report to a CSV file
                    CSVFileOutput write = new CSVFileOutput();
                    write.outputToCSVFile(studentReportDatacsv);
                    break;
                case "3":
                    // Output the student report to a text file
                    TextFileOutput writetxt = new TextFileOutput();
                    writetxt.outputToTextFile(studentReportData);
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
