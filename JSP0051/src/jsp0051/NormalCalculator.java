/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0051;

import java.util.Scanner;


public class NormalCalculator {
    public double s1;
    public double s2;
    public char operator;
    public double memory;
    public double Result;
    public static Scanner sc = new Scanner(System.in);
    
    public boolean check(char p){
        if(p == '+' || p == '-' || p == 'x' || p == '/' || p == '^' || p == '='){
            return true;
        }else{
            
            return false;
        }
    }
    
    char getOperator(){
        String s;
        do{
            System.out.println("Enter Operatoe: ");
            s = sc.nextLine();
        }
        while(! check(s.charAt(0)));
        return s.charAt(0);  
    }

    public  NormalCalculator() {
        System.out.println("Enter Number: ");
        s1 = sc.nextDouble();
        operator = getOperator();
        System.out.println("Enter Number: ");
        s2 = sc.nextDouble();
        
    }
    
    public  NormalCalculator(double s1) {
        this.s1=s1;
        operator = getOperator();
        if(operator != '=')  {
        System.out.println("Enter Number: ");
        s2 = sc.nextDouble();
        }
    }
    
    public void Calculate(){
        switch(operator)
        {
            case '+': Result = s1 + s2;
                break;
                
            case '-': Result = s1 - s2;
                break;
                
            case 'x': Result = s1 * s2;
                break;
                
            case '/': Result = s1 / s2;
                break;
              
            case '^': Result = Math.pow(s1, s2);
                break;
                
            case '=': Result = s1;
                break;                  
        }
        System.out.println("Memory: " + memory);
    }
    
    public boolean last(){
        return (operator == '=');
    }
    
    double getResult(){
        return Result;
    }
}
