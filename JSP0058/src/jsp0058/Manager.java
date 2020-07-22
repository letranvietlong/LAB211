/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Hi
 */

public class Manager {
    public static int menu() {
        System.out.println("======= Dictionary program =======");
        System.out.println("Press 1: Add new word.");
        System.out.println("Press 2: Delete word.");
        System.out.println("Press 3: Search word.");
        System.out.println("Press 4: Translate word");
        System.out.println("Press 5: Exit.");
        System.out.println("===================================");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }

    //add new word
    public static void addNewWord(HashMap<String, String> hm) {
        System.out.println("------------ ADD-----------");
        System.out.print("Enter English: ");
        String eng = Validation.checkInputString();
        for (String keyEnglish : hm.keySet()) {
            if (eng.equalsIgnoreCase(keyEnglish)) {
                System.out.println("Key english is exit");
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String viet = Validation.checkInputString();
        hm.put(eng, viet);

        try {
            FileWriter fw = new FileWriter("Translate.txt", true);
            BufferedWriter br = new BufferedWriter(fw);
            br.append("1-" + eng + "-" + viet);
            br.newLine();
            br.flush();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    //delete word
    public static void deleteWord(HashMap<String, String> hm) {
        System.out.println("---------- DELETE ----------");
        ArrayList<String> list = new ArrayList<>();
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        hm.remove(english);
        boolean check = false;
        try {
            FileReader fw = new FileReader("Translate.txt");
            BufferedReader br = new BufferedReader(fw);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains(english)) {
                    line = line.replace("1", "0");
                    check = true;
                }
                list.add(line);
            }
            br.close();

            FileWriter f = new FileWriter("Translate.txt");
            BufferedWriter b = new BufferedWriter(f);
            for (String s : list) {
                b.write(s);
                b.newLine();
            }
            b.flush();
            b.close();
            System.err.println("Delete Succesfull!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //translate
    public static void translate(HashMap<String, String> hm) {
        System.out.println("---------- TRANSLATE ----------");
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }
    
    public void search(HashMap<String, String> hm) {
        System.out.print("Enter keyEnglish to search: ");
        String key = Validation.checkInputString();
        System.out.println("Vietnamese: " + hm.get(key));
        System.out.println("Search successfull");
    }

    public static boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
