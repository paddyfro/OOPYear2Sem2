/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author patri
 */
public class WorkingStacks
{

    public static void main(String args[])
    {
        testStacks();

        testPriorityQueue();

    }

    public static void testPriorityQueue()
    {
        System.out.println("\n priority queues");
        PriorityQueue<WorkOrder> q = new PriorityQueue<>();
        q.add(new WorkOrder(6, "Blow the bLoody doors off"));
        q.add(new WorkOrder(3, "Shampoo Caroets"));
        q.add(new WorkOrder(7, "Sort life out"));
        q.add(new WorkOrder(1, "Fix Broken Sink"));
        q.add(new WorkOrder(7, "Get liz back"));
        q.add(new WorkOrder(2, "Order cleaning supplies"));
        q.add(new WorkOrder(1, "fluff the dog groomer"));

        while (q.size() > 0)
        {
            System.out.println(q.remove());
        }
    }

    public static void testStacks()
    {
        System.out.println("\n\n stacks");
        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        s.push("D");

        System.out.println("peek: " + s.peek());
        //loop
        while (s.size() > 0)
        {
            System.out.println(s.pop());
        }

        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i <= 10; i++)
        {
            s1.push(i);
        }

        while (s1.size() > 0)
        {
            System.out.println(s1.pop());
        }
    }

}
