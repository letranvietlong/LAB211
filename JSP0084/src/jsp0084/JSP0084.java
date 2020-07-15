/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0084;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author macbook
 */

public class JSP0084 {

        public static String checkInput() {
        String pattern = "\\d+";
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty!!!");
                continue;
            }
            if (!input.matches(pattern)) {
                System.err.println("Only number!!!");
                continue;
            }
            return input;
        }
    }

    public static void main(String[] args) {
        String numOne = checkInput();
        String numTwo = checkInput();
        BigInteger bigNumOne = new BigInteger(numOne);
        BigInteger bigNumTwo = new BigInteger(numTwo);
        System.out.println(bigNumOne.multiply(bigNumTwo));
    }
    
}
