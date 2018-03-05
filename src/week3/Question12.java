package week3;

// Question 12 - Implement TO-DO List using PriorityQueue
//package collections_solutions;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question12 {

    PriorityQueue<Task> tasks = new PriorityQueue<>();

    public static void main(String[] args) {
        new Question12().start();
    }

    public void start() {

        Scanner in = new Scanner(System.in);
        String choice = "";
        System.out.println("Enter a command: e.g. add 4 mathhomework");
        while (!choice.equals("quit")) {
            System.out.print("Command: ");
            choice = in.nextLine();
            if (choice.equalsIgnoreCase("next")) {
                Task t = tasks.poll();
                if (t == null) {
                    System.out.println("No tasks. You're done");
                } else {
                    System.out.println(t.toString());
                }
            } else if (choice.contains("add")) {
                int firstSpace = choice.indexOf(' ');
                int secondSpace = choice.indexOf(' ', firstSpace + 1);

                String priorityStr = choice.substring(firstSpace, secondSpace).trim();
                int priority = Integer.parseInt(priorityStr);
                String desc = choice.substring(secondSpace + 1);
                Task task = new Task(priority, desc);
                tasks.add(task);
            }else if(choice.contains("print"))
            {
                print();
            }
        }
    }

    public void print() {
        System.out.println("\n print of queue");
        while(!tasks.isEmpty())
        {
            System.out.println(tasks.poll());
        }

    }
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package week3;
//
///**
// *
// * @author patri
// */
//public class Question12 {
//    
//    
//    
//    public static void main(String args[])
//    {
//        new Question12().start();
//    }
//    
//    public void start()
//    {
//        
//    }
//    
//}
