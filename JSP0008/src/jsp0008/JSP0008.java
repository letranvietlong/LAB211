/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Viet Long
 */
public class JSP0008 {

    /**
     * @param args the command line arguments
     */
    
    private Map<Character, Integer> charJSP0008 = 
            new HashMap<Character, Integer>();
    
    private Map<String, Integer> wordJSP0008 =
            new HashMap<String, Integer>();

    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
       
        JSP0008 counter = new JSP0008();
        counter.analyze(content);
        counter.display();
    }
    
    public void display() {
        System.out.println(wordJSP0008);
        System.out.println(charJSP0008);
    }
    
    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (!charJSP0008.containsKey(ch)) {
                charJSP0008.put(ch, 1);
            } else {
                charJSP0008.put(ch, ((int) charJSP0008.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordJSP0008.containsKey(token)) {
                wordJSP0008.put(token, 1);
            } else {
                wordJSP0008.put(token, ((int) wordJSP0008.get(token)) + 1);
            }
        }
    }
}
