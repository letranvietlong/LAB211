/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0004;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class MyArray {

    /**
     * @param args the command line arguments
     */
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

    int partition(int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    void quickSort(int left, int right) {
        int index = partition(left, right);
        if (left < index - 1) {
            quickSort(left, index - 1);
        }
        if (index < right) {
            quickSort(index, right);
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
        int size = scanner.nextInt();
        arr = new MyArray(size);
        arr.randomArr();
        System.out.print("Unsorted array: ");
        arr.display();
        arr.quickSort(0, size - 1);
        System.out.println("Sorted array: ");
        arr.display();
        
    }

    
}
