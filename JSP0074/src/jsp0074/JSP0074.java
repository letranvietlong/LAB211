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
public class JSP0074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1. Add two matrix.");
        System.out.println("2. Sub two matrix.");
        System.out.println("3. Multi two matrix.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice:");
        do {
            choice = sc.nextInt();
            matran mt = new matran();
            matran mt2 = new matran();
            switch (choice) {
                case 1:

                    matran result = matran.add(mt, mt2);
                    result.display();
                    break;
                case 2:

                    matran result2 = matran.sub(mt, mt2);
                    result2.display();
                    break;
                case 3:

                    matran result3 = matran.mul(mt, mt2);
                    result3.display();
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }

}
