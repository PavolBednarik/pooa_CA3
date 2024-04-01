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
 *
 * @author pavol
 */
public class StudentReportOutput {
    private Scanner sc;

    public StudentReportOutput() {
        sc = new Scanner(System.in);
    }

    public void studentOutputMenu() throws SQLException {
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
            StudentReport studentReport = new StudentReport();
            ArrayList<String> studentReportData = studentReport.getPassingStudentReport();
            ConsoleOutput.StudentReport(studentReportData);
        } catch (SQLException e) {
        }
    }

    private void outputToCSVFile() throws SQLException {
        StudentReport studentReport = new StudentReport();
        ArrayList<String> studentReportData = studentReport.getPassingStudentReportcsv();
        CSVFileOutput write = new CSVFileOutput();
        write.outputToCSVFile(studentReportData);
    }

    private void outputToTextFile() throws SQLException {
        StudentReport studentReport = new StudentReport();
        ArrayList<String> studentReportData = studentReport.getPassingStudentReport();
        TextFileOutput write = new TextFileOutput();
        write.outputToTextFile(studentReportData);
    }
}