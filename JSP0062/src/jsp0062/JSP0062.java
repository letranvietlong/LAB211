/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0062;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class JSP0062 {

     private static final Scanner in = new Scanner(System.in);

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static void checkInputPath() {
        System.out.println("===== Analysis Path Program =====");
        System.out.print("Please input Path: ");
        String path = checkInputString();
        System.out.println("\n----- Result Analysis -----");
        System.out.println("Disk: " + getDisk(path));
        System.out.println("Extension: " + getExtension(path));
        System.out.println("File name: " + getFileName(path));
        System.out.println("Path: " + getPath(path));
        System.out.print("Forder: ");
        getForders(path);
        System.out.println("");
        System.out.println("------------------------------");
        
    }
    
    private static String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon);
    }
    
    private static String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot, path.length());
    }
    
    private static String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    private static String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(0, toNameFile);
    }

//    private static String getForder(String path) {
//        int positionColon = path.indexOf("\\");
//        int positionDot = path.lastIndexOf("\\");
//        path = path.substring(positionColon, positionDot);
//        String[] splitFile = path.split("\\\\");
//        return splitFile[splitFile.length - 1];
//    }
    
    private static String[] getForder(String path) {
        String[] splitFile = path.split("\\\\");
        return splitFile;
    }
    private static void getForders(String path){
        String[] getFolders = getForder(path);
        for (int i = 1; i < getFolders.length - 1; i++) {
            System.out.print(" ["+getFolders[i]+"]");

        }
    }

    public static void main(String[] args) {
        checkInputPath();
    }
    
}
