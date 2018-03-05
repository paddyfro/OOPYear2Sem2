/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author patri
 */
public class question08 {

    public static void main(String[] args) {

//        new hashMap<wordMap, String>()
        Map<String, String> wordMap = new HashMap<>();
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {

            String line;   // line of text from file
            while ((line = br.readLine()) != null) {

//                System.out.println("*** line = " + line + " ***");
                // create tokenizer and set the delimeter character
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ,");

                while (stringTokenizer.hasMoreElements()) {

                    String name = stringTokenizer.nextElement().toString();

//                    System.out.print(name + " ");
                }
//                System.out.println("");
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
