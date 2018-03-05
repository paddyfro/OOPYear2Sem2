// Question 1 - Remove every Nth element from List
//This code creates an Arraylist, Populates it, then it remvoes the 4th element from the List and copy's it
//to a new ArrayList
package week2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question01 {


		public static void main(String [] args)
  	{
  		new Question01().start();
  	}
    
    public void start()
    {
        List<Integer> nums = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();        
//        nums.add(8);
//        nums.add(8);
//        nums.add(8);
//        nums.add(2);
//        nums.add(2);
//        nums.add(2);
//        nums.add(9);
//        nums.add(9);
//        nums.add(3);
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        System.out.print("Original List: ");
        display(nums);
        List<Integer> revised = removeN(nums, 4);
        System.out.print("Revised List: ");
        display(revised);
        
        split(nums, left, right);
        
        removeDuplicates2(nums);
    }

    public List<Integer> removeN(List<Integer> nums, int n)
    {
        List<Integer> returnNums = new ArrayList<>();
        for (int i = 1; i <= nums.size(); i++) {
            if (i % n != 0) {
                returnNums.add(nums.get(i - 1));
            }
        }
        return returnNums;
    }

    public void display(List<Integer> nums)
    {
        System.out.print("[");
        for (int x = 0; x < nums.size(); x++) {
            Integer i = nums.get(x);
            if (x != 0) {
                System.out.print(", ");
            }
            System.out.print("" + i);
        }
        System.out.println("]");
    }
    
    //Spliting the Original ArrayList in two halves, right down the middle
    public void split(List<Integer> original, List<Integer> left, List<Integer> right)
    {
        int midpoint = original.size() / 2;
        for (int i = 1; i <= original.size(); i++) {
            if (i <= midpoint) {
                left.add(original.get(i - 1));
            }
            else
            {
                right.add(original.get(i - 1));
            }
        }
        System.out.println("");
        System.out.print("Original List: ");
        display(original);
        
        System.out.print("Left List: ");
        display(left);
        
        System.out.print("Right List: ");
        display(right);               
        
    }
    
 public void removeDuplicates(List<Integer> original)
 {
     int hold = 0;
     for (int i = 1; i <= original.size(); i++) {
            if (original.get(i) == hold) {
                original.remove(i);
            }
            else
            {
                hold = original.get(i);
            }
        }
     
 }
 public void removeDuplicates2(List<Integer> original)
 {
     Iterator<Integer> iter = original.iterator();
     int hold = 0;
     if(iter.hasNext())
     {
         hold = iter.next(); // Stores first
     }
     
     int concant;
     while(iter.hasNext())
     {
         concant = iter.next();
         if (concant == hold)
         {
             iter.remove();
         }
         else
         {
             hold = concant;
         }
     }
     
     System.out.println("");
    display(original);               

             
     
 }
 

}
