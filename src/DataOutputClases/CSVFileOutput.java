/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataOutputClases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Handles the output of data to a CSV file.
 * This class provides functionality to write an ArrayList of strings to a CSV file.
 * Each string in the ArrayList is expected to represent one line in the CSV file.
 */
public class CSVFileOutput {
    // Increment the report counter to ensure a unique filename for each report.
    private static int reportCounter = 0;
    // output to csv file
    public void outputToCSVFile(ArrayList<String> data) {
        //file name report
        reportCounter++;
        String filename = "report" + reportCounter + ".csv";
        try {
            //using bufferedwriter to write in file
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            //loop to write all data available
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("REPORT SUCCESSFULLY GENERATED " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
