/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0073;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author macbook
 */

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final String DATE_VALID = "^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$";
    
    private static void menu() {
        ArrayList<Expense> ex = new ArrayList<>();
        int ID = 0;
        while (true) {
            System.out.println("=====Handy Expense Program=====");
            System.out.println("Press 1: Add an expense");
            System.out.println("Press 2: Display all expenses");
            System.out.println("Press 3: Delete an expense");
            System.out.println("Press 4: Quit");
            System.out.println("================================");
            System.out.print("Your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(ex, ++ID);
                    break;
                case 2:
                    displayExpense(ex);
                    break;
                case 3:
                    deleteExpense(ex);
                    ID--;
                    break;
                case 4:
                    return;
            }
        }
    }
    
    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputDate() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.matches(DATE_VALID)) {
                    return result;
                } else {
                    System.err.println("Please input Date in format (Ex: 22-Apr-2000)");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Re-input");
            } else {
                return result;
            }

        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static void addExpense(ArrayList<Expense> ex, int ID) {
        System.out.print("Enter Date: ");
        String date = checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = checkInputDouble();
        System.out.print("Enter Content: ");
        String content = checkInputString();
        ex.add(new Expense(ID, date, amount, content));
    }

    private static void displayExpense(ArrayList<Expense> ex) {
        if (ex.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < ex.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", ex.get(i).getId(), ex.get(i).getDate(), ex.get(i).getAmount(), ex.get(i).getContent());
            total += ex.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    private static int checkIdExist(ArrayList<Expense> ex, int ID) {
        for (int i = 0; i < ex.size(); i++) {
            if (ex.get(i).getId() == ID) {
                return i;
            }
        }
        return -1;
    }

    private static void deleteExpense(ArrayList<Expense> ex) {
        System.out.print("Enter ID: ");
        int ID = checkInputInt();
        int checkIDExist = checkIdExist(ex, ID);
        if (checkIDExist != -1) {
            ex.remove(checkIDExist);
            System.out.println("Delete an expense successful");
            for (int i = ID - 1; i < ex.size(); i++) {
                ex.get(i).setId(ex.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    public static void main(String[] args) throws IOException {
        menu();
    }
}
    

