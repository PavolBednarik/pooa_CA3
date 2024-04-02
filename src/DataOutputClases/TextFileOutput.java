/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataOutputClases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Handles the output of data to a text file.
 * This class provides functionality to write an ArrayList of strings to a text file,
 * incrementing a counter with each new report to ensure unique filenames.
 */
public class TextFileOutput {
    // Static counter to ensure each report has a unique filename
    private static int reportCounter = 0;
    
    // output to text file
    public void outputToTextFile(ArrayList<String> data) {
        //file name report
        reportCounter++;
        String filename = "report" + reportCounter + ".txt";
        try {
            //using bufferedwriter
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
