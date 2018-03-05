// Question 6 - Map of Students -> Grades
package week3;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Question06 {

    Scanner in = new Scanner(System.in);
    Map<String, String> results = new TreeMap<>();  // TreeMap sorts by key

    public static void main(String args[]) {
        Question06 q = new Question06();
        q.start();
    }
    

    public  void start() {
        

        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Add Grade");
            System.out.println("2. View All Grades");
            System.out.println("3. Change Grade");
            System.out.println("4. Remove Grade and Student");
            System.out.println("5. Exit");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    addGrade(results);
                    break;
                case 2:
                    viewAllGrades(results);
                    break;
                case 3:
                    changeGrade(results);
                    break;
                case 4:
                    removeGrade(results);
                    break;
            }
        }
    }

    private void addGrade(Map<String, String> results) {
        System.out.println("Please enter student name: ");
        String name = in.nextLine();
        System.out.println("Please enter student grade: ");
        String grade = in.nextLine();
        results.put(name, grade);
    }

    private void changeGrade(Map<String, String> results) {
        System.out.println("Please enter student name: ");
        String name = in.nextLine();
        if (results.containsKey(name)) {
            System.out.println("Please enter new grade: ");
            String grade = in.nextLine();
            results.put(name, grade);
        } else {
            System.out.println("Sorry no student with that name added");
        }
    }

    private void removeGrade(Map<String, String> results) {
        System.out.println("Please enter student name: ");
        String name = in.nextLine();
        if (results.containsKey(name)) {
            System.out.println("Are you sure you would like to delete " + name);
            String ans = in.nextLine().toLowerCase();
            if (ans.charAt(0) == 'y') {
                results.remove(name);
                System.out.println("student removed");
            }
        }
    }

    private void viewAllGrades(Map<String, String> results) {
        Iterator<String> iter = results.keySet().iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            String grade = results.get(name);
            System.out.println(name + ": " + grade);
        }
    }
}
