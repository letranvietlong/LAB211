/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0063;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Person {
    private String name;
    private String address;
    private double salary;
    
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public void inputPersonInfo() {
        System.out.println("Input Person Information.");
        System.out.print("Please input name: ");
        name = sc.nextLine();
        System.out.print("Please input address: ");
        address = sc.nextLine();
        do{
            System.out.print("Please input salary: ");
            try{
                String s = sc.nextLine();
                salary = Double.parseDouble(s.trim());
                if(salary < 0){
                    System.out.println("Salary greater than zero");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("You must input digit");
            }
        }while(true);       
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", salary=" + salary + '}';
    }
    
    
}
