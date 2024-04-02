/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import DataOutputClases.CSVFileOutput;
import DataOutputClases.ConsoleOutput;
import DataOutputClases.TextFileOutput;
import ReportsGenerator.LecturerReport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pavol
 */
public class LecturerReportOutput {
    private Scanner sc;

    public LecturerReportOutput() {
        sc = new Scanner(System.in);
    }

    public void lecOutputMenu() {
        int choice;
        do {
            System.out.println("Choose output option:");
            System.out.println("1. Output to Console");
            System.out.println("2. Output to CSV File");
            System.out.println("3. Output to Text File");
            System.out.println("4. Exit course report menu");
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
                    System.out.println("Exiting menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void outputToConsole() {
        try {
            LecturerReport lecturerReport = new LecturerReport();
            ArrayList<String> lecturerReportData = lecturerReport.getLecturerReport();
            ConsoleOutput.CourseReport(lecturerReportData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void outputToCSVFile() {
        try {
            LecturerReport lecturerReport = new LecturerReport();
            ArrayList<String> lecturerReportData = lecturerReport.getLecturerReportcsv();
            CSVFileOutput write = new CSVFileOutput();
            write.outputToCSVFile(lecturerReportData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void outputToTextFile() {
        try {
            LecturerReport lecturerReport = new LecturerReport();
            ArrayList<String> lecturerReportData = lecturerReport.getLecturerReport();
            TextFileOutput write = new TextFileOutput();
            write.outputToTextFile(lecturerReportData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
