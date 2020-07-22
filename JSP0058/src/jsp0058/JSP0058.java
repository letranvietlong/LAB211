/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0058;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author Hi
 */

public class JSP0058 {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        try{
            FileReader fr = new FileReader("Translate.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String d[] = line.split("-");
                if(d[0].equals("1")){
                    hm.put(d[1], d[2]);
                }
            }
            br.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addNewWord(hm);
                    break;
                case 2:
                    Manager.deleteWord(hm);
                    break;
                case 3:
                    Manager.translate(hm);
                    break;
                case 4:
                    Manager.translate(hm);
                    break;
                case 5:
                    return;
            }
        }
    }
    
}
