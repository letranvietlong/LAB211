/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlp0021;

/**
 *
 * @author Viet Long
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Management m = new Management();

        int choice;
        do {
            choice = Menu.Menu();
            switch (choice) {
                case 1: {                    
                    m.Creat();
                    m.output();
                    break;
                }
                case 2: {
                    m.findAndSort();
                    break;
                }
                case 3: {
                    m.updateAndDelete();
                    break;
                }
                case 4: {
                    m.Report();
                    break;
                }
                case 5: {
                    break;
                }

            }

        } while (choice != 5);
    }

}
