/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0083;

import java.util.Stack;

/**
 *
 * @author macbook
 */
public class MyStack {

    Stack stack = new Stack();
    
    int value;

    public MyStack() {
        
    }

    public MyStack(int value) {
        this.value = value;
    }

    public void push(int value) {
        stack.push(value);
    }

    public void pop() {
        System.out.println(stack.pop());
    }

    public void get(int position) {
        System.out.println(stack.get(position));
    }

    public static void main(String[] args) {
        
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        MyStack myStack = new MyStack();
        
        for (int i = 0; i < list.length; i++) {
            myStack.push(list[i]);
        }
        
        myStack.pop();
        myStack.pop();
        
        for (int i = 0; i < 3; i++) {
            myStack.get(i);
        }
    }
    
}
