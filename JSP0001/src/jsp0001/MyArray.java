/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0001;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class MyArray {

    private int[] arr;
    private int size;
    private static Scanner scanner = new Scanner(System.in);
    
    public MyArray(){
        
    }
    
    public MyArray(int size){
        this.size = size;
        arr = new int[size];
    }
    
    public void randomArr(){
        for(int i =0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 30);
        }
    }

    public void BubbleSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length -1; j >i; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
           
    }

    public void display() {
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println("");
        
    }
    
    

    public static void main(String[] args) {
        MyArray arr;
        System.out.print("Enter size of array: ");
        arr = new MyArray(scanner.nextInt());
        arr.randomArr();
        System.out.print("Unsorted array: ");
        arr.display();
        arr.BubbleSort();
        System.out.println("Sorted array: ");
        arr.display();
        
    }


}    
