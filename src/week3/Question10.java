package week3;

import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patri
 */
public class Question10 {

    Scanner kb = new Scanner(System.in);
    Stack<String> stacker = new Stack<>();

    public static void main(String args[]) {
        Question10 q = new Question10();
        q.start();
    }

    public void start() {
        System.out.println("testing this format");
        readInValues();
        printStack();
    }

    public void readInValues() {
        String input = "";
        System.out.println("Please enter word (-1 to exit) : ");
        while (!input.equals("-1")) {
            System.out.print(":");
            input = kb.next();
//            System.out.println("word: " + input);
            if (!input.equals("-1")) {
                stacker.push(input);
            }
        }
    }

    public void printStack() {
        System.out.println("Values in ze stack!");
        //while(!stacker.empty());
        while (stacker.size() > 0) {
            System.out.println(stacker.pop());
        }
    }

}


/**
 * dermots code
 * 
 * -// Question 10 - Reverse order of entered words - using Stack
//
//package collections_solutions;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Question10
{

	public static void main(String[] args)
	{
		new Question10().start().
	}
    public void start()
    {
        Stack<String> stack = new Stack();  
       // Note that API documentation recommends using a ArrayDeque class
       // and Deque interface to implement a Stack 
       // Deque<String> stack = new ArrayDeque<>();
       // The Stack concept and operation is the same in both cases.
        
        Scanner in = new Scanner(System.in);
        String word = "";
        System.out.println("Please enter a list of words, -1 to exit");
        while(!word.equals("-1"))
        {
            word = in.next();
            if(!word.equals("-1"))
            {
                stack.push(word);
            }
        }
        
        System.out.println("Your words in reverse order are: ");
        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }
    }
}
 * 
 * 
 */
