// Question 7 - Map: Student objects => Grades

// Note that the Student object is the key, so to 
// order elements in TreeMap, the Student class
// must implement the Comparable interface

package week3;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Scanner;

public class Question07 {

    Scanner in = new Scanner(System.in);
    
    public static void main(String args[]){
        Question07 q = new Question07();
        q.start();
    }

    public void start()
    {
        Map<Student, String> results = new TreeMap<>();  // order by Student 
                                                         //(see compareTo() in Student)
                                                         
        Map<Integer, Student> students = new HashMap<>();  

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
                    addGrade(results, students);
                    break;
                case 2:
                    viewAllGrades(results);
                    break;
                case 3:
                    changeGrade(results, students);
                    break;
                case 4:
                    removeGrade(results, students);
                    break;
            }
        }

    }

    private void addGrade(Map<Student, String> results, Map<Integer, Student> students)
    {
        System.out.println("Please enter student first name: ");
        String fname = in.nextLine();
        System.out.println("Please enter student last name: ");
        String lastname = in.nextLine();
        Student s = new Student(fname, lastname);
        System.out.println("Please enter student grade: ");
        String grade = in.nextLine();
        results.put(s, grade);
        students.put(s.getID(), s);

    }

    private void changeGrade(Map<Student, String> results, Map<Integer, Student> students)
    {
        System.out.println("Please enter student ID: ");
        int id = in.nextInt();
        in.nextLine();

        if (students.containsKey(id)) {
            System.out.println("Please enter new grade: ");
            String grade = in.nextLine();
            Student s = students.get(id);
            results.put(s, grade);
        } else {
            System.out.println("Sorry no student with that ID");
        }
    }

    private void removeGrade(Map<Student, String> results, Map<Integer, Student> students)
    {
        System.out.println("Please enter student ID: ");
        int id = in.nextInt();
        in.nextLine();
        if (students.containsKey(id)) {
            System.out.println("Are you sure you would like to delete " + id);
            String ans = in.nextLine().toLowerCase();
            if (ans.charAt(0) == 'y') {
                Student s = students.get(id);
                results.remove(s);
                System.out.println("student removed");
            }
        }
    }

    private void viewAllGrades(Map<Student, String> results)
    {
        Iterator<Student> iter = results.keySet().iterator();
        while (iter.hasNext()) {
            Student name = iter.next();
            String grade = results.get(name);
            System.out.println(name + ": " + grade);
        }
    }
}




