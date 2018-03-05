// Question 5 - create index of words and line numbers from text file
package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Question05
{
    public static void main(String args[])
    {
        start();
    }
    
    public static void start()
    {
        try
        {            
            Map<String, Set<Integer>> index = new TreeMap<>();  // sorted order
            
            Scanner in = new Scanner(new File("words.txt"));
            int lineNumber = 0;
            while(in.hasNextLine())  // read text line-by-line
            {
                lineNumber++;
                String line = in.nextLine();
                line = line.replace('.', ' ');
                line = line.replace(',', ' ');
                
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens())  // get each word
                {
                    String word = st.nextToken().toLowerCase();
                    if(index.containsKey(word))
                    {
                        index.get(word).add(lineNumber);
                    }
                    else
                    {
                        Set<Integer> lines = new HashSet<>();
                        lines.add(lineNumber);
                        index.put(word, lines);
                    }        
                }  
            }
            // display the index
            Set<String> keys = index.keySet();
            Iterator<String> iter = keys.iterator();
            while(iter.hasNext())
            {
                String key = iter.next();
                System.out.print(key + ": ");
                Set<Integer> nums = index.get(key);
                Iterator<Integer> valueIter = nums.iterator();
                while(valueIter.hasNext())
                {
                    Integer line = valueIter.next();
                    System.out.print(line);
                    if(valueIter.hasNext())
                    {
                        System.out.print(", ");
                    }
                }
                System.out.println("");
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Question05.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}








///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package week2;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
///**
// *
// * @author patri
// */
//public class Question5 {
//
//    public static void main(String args[]) throws FileNotFoundException {
//
//        HashMap<Integer, String> words = readInFile();
//        findWord(words);
////readInFile();
//    }
//
//    public static HashMap<Integer, String> readInFile() throws FileNotFoundException {
//        int count =0;
//        
//        HashMap<Integer, String> words = new HashMap<Integer, String>();
//        
//        Scanner in = new Scanner(new File("words.txt"));
//        in.useDelimiter("\n");
//        while (in.hasNext()) {
//            String line = in.next();
//            
////            System.out.println("count: " + count);
//            System.out.println(line);
//            words.put(count, line);
//            count++;
//        }
//        return words;
//    }
//    
//    public static void findWord(HashMap<Integer, String> words)
//    {
//        for(Integer key : words.keySet())
//        {
//            System.out.println(words.get(key));
//        }
//    }
//
//}
