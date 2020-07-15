/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlp0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Hi
 */
class Manager {
    static int menu() {
        //menu        
        System.out.println("===== FRUIT SHOP SYSTEM =====");
        System.out.println("Press 1: Create Fruit");
        System.out.println("Press 2: View orders");
        System.out.println("Press 3: Shopping (for buyer)");
        System.out.println("Press 4: Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice: ");    
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    static void createFruit(ArrayList<Fruit> lf) {
        while (true) {
            System.out.print("Enter Fruit ID: ");
            String fruitId = Validation.checkInputString();
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter Fruit Name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter Price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter Quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter Origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    static void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<Order>> ht) {
        if (lf.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            displayListFruit(lf);
            System.out.print("Enter Item: ");
            int item = Validation.checkInputIntLimit(1, lf.size());
            Fruit fruit = getFruitByItem(lf, item);
            System.out.print("Enter Quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(lo, fruit.getFruitId(), quantity);
            } else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayListOrder(lo);
        System.out.print("Enter Name: ");
        String name = Validation.checkInputString();
        ht.put(name, lo);
        System.err.println("Add Successfull");
    }

    static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
