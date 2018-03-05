/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywriteobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class MyWriteObject {

    static final String dataFile = "namesdata.dat";

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<String> namesList = new ArrayList<>();
        namesList.add("Tome");
        namesList.add("Jeffery");
        namesList.add("PAtrick");

        int testInt = 69;

        Student s1 = new Student("jeff", 18);
        Student s2 = new Student("Mandy", 18);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFile));

        out.writeObject(namesList);
        out.writeInt(testInt);
        out.writeObject(s1);
        out.writeObject(s2);
        out.writeObject(students);

//        for(String name : namesList)
//        {
//            out.writeObject(name);
//        }
        out.flush();;
        out.close();

//        ArrayList<String> list1 = new ArrayList<>();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFile));

        ArrayList<String> name = (ArrayList<String>) in.readObject();
        int readInt = in.readInt();
        Student s3 = (Student) in.readObject();
        Student s4 = (Student) in.readObject();
        ArrayList<Student> stu = (ArrayList<Student>) in.readObject();
        

        System.out.println(name.get(0));
        System.out.println(name.get(1));
        System.out.println("int: " + readInt);
        System.out.println(stu.get(0));
        System.out.println(s3);
        System.out.println(s4);

//        try {
//            while (true) {
//                list1.add(in.readObject());
//            }
//        } catch (EOFException e) {
//        }
    }

}
