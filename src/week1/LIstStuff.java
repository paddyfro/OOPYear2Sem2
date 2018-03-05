/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author patri
 */
public class LIstStuff
{
    public static void main(String args[])
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        
        list1.add("Mick");
        list1.add("mary");
        list1.add("Fagan");
        list1.add("Mandy");
        list1.add("Patrick");
        
        list2.add("Cillian");
        list2.add("Dave");
        list2.add("Aidan");
        list2.add("Linda");
        list2.add("Sharon");
        list2.add("Emma");
        
        System.out.println("\tlist 1");
        displayList(list1);
        
        System.out.println("\n\tlist 2");
        displayList(list2);
        
        
    }
    
    public static void displayList(Collection<String> list)
    {
        
//        for(String l : list)
//        {
//            System.out.println(l);
//        }
        
        //iterator
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
    
}
