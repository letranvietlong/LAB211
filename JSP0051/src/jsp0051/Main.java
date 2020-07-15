/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0051;

import java.util.Scanner;

/**
 *
 * @author Viet Long
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static int menu(){
        System.out.println("====CALCULATOR PROGRAM====");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter Your Choice: ");
        return scanner.nextInt();
    }
    
    public static void main(String[] args) {
        int choice;
        do{
            choice = menu();
            switch(choice)
            {
                case 1:
                    NormalCalculator  c=new NormalCalculator();
                    c.Calculate();
                    System.out.print("Memory Number: "+c.getResult());
                    boolean flag=true;
                    do {
                        c = new NormalCalculator(c.getResult());
                        c.Calculate();
                        flag = c.last();
                        if(!flag)
                        System.out.print("Memory Number: "+c.getResult());
                        else {
                            System.out.println("Result: " + c.getResult());
                        }
                    } while (! c.last());
                    
                    break;
                
                case 2:
                    BMICalculator b = new BMICalculator();
                    b.CalculatorBMI();
                    break;
                
                case 3:
                    break;
            }
    }while (choice != 3);
}
}