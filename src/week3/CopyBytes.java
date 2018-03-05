/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CopyBytes {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> list = new ArrayList<>();

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("words.txt");
            out = new FileOutputStream("outagainEdit.txt");
            int c;
            int count = 0;

            while ((c = in.read()) != -1) {
                if (count % 2 == 0) {
                    list.add(c);
//                    out.write(c);
//                    System.out.println("add" + count);
                }
                count++;
            }
            Collections.sort(list);
            
            for (Integer l : list) {
                out.write(l);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
