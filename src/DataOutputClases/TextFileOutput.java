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
public class TextFileOutput {
    // output to text file

    public void outputToTextFile(ArrayList<String> data) {
        //file name report
        String filename = "report.txt";
        try {
            //using bufferedwriter
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            //loop to write all data available
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
