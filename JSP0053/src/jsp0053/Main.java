/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0053;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);
    
     private static int menu() {
        System.out.println("====== Bubble Sort Program ======");
        System.out.println("1. Input Array.");
        System.out.println("2. Sort Array Ascending.");
        System.out.println("3. Sort Array Desceding.");
        System.out.println("4. Exit.\n");
        System.out.print("Enter your choice: ");
     
         while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Only choice number 1 to 4.");
                System.out.print("Choice number again: ");
            }
        }
    }
    
    private static int checkInputInt() {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.out.print("Input number again: ");
            }
        }
    }

    private static int inputSizeOfArray() {
        System.out.print("Input Size Of Array: ");

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number greater than zero.");
                System.out.print("Input size again: ");
            }
        }
    }

    
    private static int[] inputValueOfArray() {
        int n = inputSizeOfArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input number " + i + ": ");
            a[i] = checkInputInt();
        }
        return a;
    }

    private static void sortArrayAscending(int[] a) {
        int len = a.length;
        if (len == 0) {
            System.err.println("List empty.");
        }
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
                break;
            }
            System.out.print("[" + a[i] + "]->");
        }
        System.out.println();
    }

    private static void sortArrayDescending(int[] a) {
        int len = a.length;
        if (len == 0) {
            System.err.println("List empty.");
        }
        for (int i = 0; i < len - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = a[maxIndex];
                a[maxIndex] = a[i];
                a[i] = temp;
            }
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
                break;
            }
            System.out.print("[" + a[i] + "]<-");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] a = new int[0];
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    a = inputValueOfArray();
                    break;
                case 2:
                    sortArrayAscending(a);
                    break;
                case 3:
                    sortArrayDescending(a);
                    break;
                case 4:
                    return;
            }
        }
    }
}
