/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlp0021;

import java.util.Scanner;

/**
 *
 * @author Viet Long
 */
public class Menu {
    static Scanner m = new Scanner(System.in);
    public static int Menu() {
        System.out.println("----WELCOM TO STUDENT MANAGEMENT----");
        System.out.println("Press 1: Creat");
        System.out.println("Press 2: Find and Sort ");
        System.out.println("Press 3: Update or Delete");
        System.out.println("Press 4: Report");
        System.out.println("Press 5: Exit");
        System.out.println("-------------------------------------");
        System.out.print("Enter your choice: ");
        return m.nextInt();
    }
}
