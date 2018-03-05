// Question 11 - Convert integer (in decimal) to binary - using Stack
package week3;

import java.util.Scanner;
import java.util.Stack; // alternatively, use ArrayDeque

public class Question11 {

    public static void main(String[] args) {
        new Question11().start();
            
	}

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter number to convert to binary");
        int num = in.nextInt();
        String output = convertToBin(num);
        System.out.println("In Binary " + num + " is " + output);
    }

    public static String convertToBin(int x) {
        Stack<Integer> s = new Stack<>();
        while (x > 0) {
            s.push(x % 2);
            x = x / 2;
        }

        String returnString = "";
        while (!s.empty()) {
            returnString += s.pop();
        }
        return returnString;
    }
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package week3;
//
//import java.util.ArrayDeque;
//import static java.util.Collections.reverse;
//import java.util.Deque;
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// *
// * @author patri
// */
//public class Question11 {
//
//    Deque<Integer> stacker = new ArrayDeque<>();
////    Stack<Integer> stacker = new Stack<>();
////    Stack<Integer> stacker2 = new Stack<>();
//    Scanner kb = new Scanner(System.in);
//
//    public static void main(String args[]) {
//        Question11 q = new Question11();
//        q.start();
//    }
//
//    public void start() {
//        System.out.println("Question 11");
//        System.out.println("convert a decimal number to a binary usinga  stack");
//        
//        System.out.println("Enter decimal number for conversion:");
//        int number = kb.nextInt();
//        
//        System.out.println("initial conversion: " + Integer.toBinaryString(number));
//        
//        convertDecToBin(number);
//
//        printStack();
//
//    }
//
//    public void convertDecToBin(int number) {
//        double rem = -1;
//        while (number != 0) {
//            number = number / 2;
////            System.out.println("number: " + number);
//            rem = number % 2;
////            System.out.println("rem: " + rem);
//            stacker.push((int) rem);
//        }
////        while (stacker.size() > 0) {
////            stacker2.push(stacker.pop());
////        }
//    }
//
//    public void printStack() {
//        System.out.println("Values in ze stack!");
//        System.out.print("Converted number: ");
////        while (stacker2.size() > 0) {
////            System.out.print(stacker2.pop());
////        }
//while(stacker.size() > 0)
//        System.out.print(stacker.pollLast());
//    }
//
//}
