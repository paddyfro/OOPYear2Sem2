package week3;

// Question 13 - Simulate a airport queue - using PriorityQueue
//package collections_solutions;

import java.util.PriorityQueue;

public class Question13
{ 
    
    public static void main(String args[])
    {
        new Question13().start();
    }
    public void start()
    {
        PriorityQueue<Passenger> passengers = new PriorityQueue<>();
        // add 120 passengers
        for(int i = 0 ; i < 120;i++)
        {
            String name = randomName();
            double isPri = Math.random();
            Passenger p = new Passenger(name, isPri < 0.15);
            passengers.add(p);
            System.out.println("Arrived: " + p);
        }
        int timeInSeconds = 0;
        while(!passengers.isEmpty())
        {
            Passenger p = passengers.poll();
            if(p.isPriority())
            {
                
                timeInSeconds+=30;
            }
            System.out.println("Boarded:" + p.toString());
        }
        System.out.println("Total time to load Priority Passengers: " + timeInSeconds/60 +" minutes " +timeInSeconds%60 + " Seconds");
    }
       
    private String randomName()
    {
          String[] fnames = {"Tony", "Natasha", "Clint", "Steve", "Bucky", "Bruce", "Peter", "Lisa", "Margaret"};
          String[] lnames = {"Stark", "Romanoff", "Barton", "Rogers", "Barnes", "Banner", "Parker", "Carter"};
          return fnames[(int)(Math.random()*fnames.length)] + " " +lnames[(int)(Math.random()*lnames.length)] ;
          
    }
}


