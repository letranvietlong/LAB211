/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0074;

import java.util.Scanner;

/**
 *
 * @author Viet Long
 */
public class matran {

    public int col;
    public int row;
    public int[][] A;
    public static Scanner sc = new Scanner(System.in);

    public matran() {
        System.out.println("Enter row of matix:");
        row = sc.nextInt();
        System.out.println("Enter col of the matrix:");
        col = sc.nextInt();
        A = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter matrix [" + (i+1) + "," + (j+1) + "]: ");
                A[i][j] = sc.nextInt();
            }
        }
    }

    public matran(int row, int col) {
        this.row = row;
        this.col = col;
        this.A = new int[row][col];
    }

    public void display() {
        System.out.println("Result: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
        
    }

    public static matran add(matran s1, matran s2) {
        if (s1.col != s2.col || s1.row != s2.row) {
            System.out.println("Can not add two matrix");
            System.out.println("Please enter matrix again");
            return null;
        }
        matran rs = new matran(s1.row, s1.col);
        for (int i = 0; i < s1.row; i++) {
            for (int j = 0; j < s1.col; j++) {
                rs.A[i][j] = s1.A[i][j] + s2.A[i][j];
            }
        }
        return rs;
    }

    public static matran sub(matran s1, matran s2) {
        if (s1.col != s2.col || s1.row != s2.row) {
            System.out.println("Can not Sub two matrix");
            System.out.println("Please enter matrix again");
            return null;
        }
        matran rs = new matran(s1.row, s1.col);
        for (int i = 0; i < s1.row; i++) {
            for (int j = 0; j < s1.col; j++) {
                rs.A[i][j] = s1.A[i][j] - s2.A[i][j];
            }
        }
        return rs;
    }

    public static matran mul(matran s1, matran s2) {
        if (s1.col == s2.row) {
            System.out.println("Can not Multi two matrix");
            System.out.println("Please enter matrix again");
            return null;
        }
        matran rs = new matran(s1.row, s2.col);
        for (int i = 0; i < s1.row; i++) {
            for (int j = 0; j < s2.col; j++) {
                for (int k = 0; k < s2.col; k++) {
                    rs.A[i][j] += s1.A[i][k] * s2.A[k][j];
                }
            }
        }
        return rs;
    }
}
