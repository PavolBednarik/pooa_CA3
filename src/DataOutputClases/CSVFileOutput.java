/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataOutputClases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author pavol
 */
public class CSVFileOutput {
    private static int reportCounter = 0;
    // output to csv file
    public void outputToCSVFile(ArrayList<String> data) {
        //file name report
        reportCounter++;
        String filename = "report" + reportCounter + ".csv";
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
