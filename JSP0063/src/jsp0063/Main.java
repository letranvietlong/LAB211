/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0063;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author macbook
 */


public class Main {    

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        for (int i =0; i <3; i++){
            Person person = new Person();
            person.inputPersonInfo();
            list.add(person);
        }
        
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }           
        });
        
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
        
    }     
        
        
    
    
    
    
}
