/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author patri
 */
public class CollectionQuestions
{

    public static void main(String args[])
    {
        System.out.println("Question 1");

//        List<Integer> listA = new ArrayList<>();

        List<Integer> listA = popList();
        
        displayList(listA);

        List<Integer> list1 = quest1(listA, 3);
        System.out.println("n = 3");
        System.out.println("new list: ");
        displayList(listA);

        System.out.println("\n\nQuestion 2");
        List<Integer> listB = popList();
        System.out.println("original List:");
        displayList(listB);
        quest2(listB);
        
        
        System.out.println("\n\nQuestion 3");
        List<String> list3 = new LinkedList<>();
        list3.add("Cillian");
        list3.add("Dave");
        list3.add("Aidan");
        list3.add("Linda");
        list3.add("Sharon");
        list3.add("Emma");
        list3.add("Emma");
        displayLinkedListString(list3);

    }

    public static void displayList(List<Integer> list)
    {

        for (Integer l : list)
        {
            System.out.print(l + ", ");
        }
    }
    
    public static void displayLinkedListString(List<String> list)
    {

        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
    
    public static List popList()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
        {
            list.add(i);
        }
        
        return list;
    }
           

    public static List quest1(List<Integer> listA, int n)
    {
        for (int i = 0; i < listA.size(); i++)
        {
            if (i == n - 1)
            {
                listA.remove(i);
            }
        }
        return listA;
    }

    public static void quest2(List<Integer> list)
    {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        if (list.size() / 2 == 0)
        {
            for (int i = 0; i < list.size() / 2; i++)
            {
                listA.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++)
            {
                listB.add(list.get(i));
            }
        } else
        {
            for (int i = 0; i < list.size() / 2; i++)
            {
                listA.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++)
            {
                listB.add(list.get(i));
            }
        }
        System.out.println("\n1st list: ");
        displayList(listA);
        System.out.println("\n2nd list: ");
        displayList(listB);

    }
    
    public static void quest3(Collection<String> list)
    {
        String old = "";
        String current;
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        {
            if(old.equals(iter.next()))
            {
//                remove(iter.next());
            }
            old = iter.next();
        }
    }
}
