/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlp0025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Hi
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            int countLine = Manager.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            while ((line = br.readLine()) != null) {
                if (Manager.isLineEmpty(line)) {
                    continue;
                }
                line = Manager.formatOneSpace(line);
                line = Manager.formatSpecialCharacters(line);
                line = Manager.afterDotUpperCase(line);
                line = Manager.noSpaceQuotes(line);
                line = Manager.firstUpercase(line);
                line = Manager.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
