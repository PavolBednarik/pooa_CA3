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
 * Menu for selecting the output format of lecturer reports. This class provides
 * functionality for displaying a menu that allows users to choose how they want
 * to view or export lecturer reports, including output to console, CSV file, or
 * text file.
 */
public class LecturerReportOutput {

    private Scanner sc;

    public LecturerReportOutput() {
        sc = new Scanner(System.in);
    }

    // display menu for lecturer report
    public void lecOutputMenu() throws SQLException {
        String choice;
        do {
            System.out.println("Choose output option:");
            System.out.println("1. Output to Console");
            System.out.println("2. Output to CSV File");
            System.out.println("3. Output to Text File");
            System.out.println("4. Exit course report menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().trim();
            // Fetch report data in preparation for output
            LecturerReport lecturerReport = new LecturerReport();
            ArrayList<String> lecturerReportData = lecturerReport.getLecturerReport();
            ArrayList<String> lecturerReportDatacsv = lecturerReport.getLecturerReportcsv();
            switch (choice) {
                case "1":
                    //output to console
                    ConsoleOutput.LecturerReport(lecturerReportData);
                    break;
                case "2":
                    //// output to csv file
                    CSVFileOutput write = new CSVFileOutput();
                    write.outputToCSVFile(lecturerReportDatacsv);
                    break;
                case "3":
                    //output to text file
                    TextFileOutput writetxt = new TextFileOutput();
                    writetxt.outputToTextFile(lecturerReportData);
                    break;
                case "4":
                    // exit lecturer menu
                    System.out.println("Exiting menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (!choice.equals("4"));
    }
}
