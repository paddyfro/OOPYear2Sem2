// Question 4 - Address Book: Map: Name => UserDetails

package week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question04 {

	public static void main(String [] args)
	{
		new Question04().start();
	}

    Scanner in = new Scanner(System.in);
    
    

    public void start()
    {
        Map<String, UserDetails> phoneBook = new HashMap<>(); 
        
                     // HashMap for speed, no ordering required
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. Add Entry");
            System.out.println("2. Find Entry");
            System.out.println("3. Delete Entry");
            System.out.println("4. Exit");
            choice = in.nextInt();

            in.nextLine(); // remove excess new line character.

            switch (choice) {
                case 1:
                    addEntry(phoneBook);
                    break;
                case 2:
                    findEntry(phoneBook);
                    break;
                case 3:
                    removeEntry(phoneBook);
            }
        }
        
    }

    private void addEntry(Map<String, UserDetails> phoneBook)
    {
        System.out.println("Please enter name: ");
        String name = in.nextLine();
        System.out.println("Please enter home phone number: ");
        String home = in.nextLine();
        System.out.println("Please enter mobile phone number: ");
        String mobile = in.nextLine();
        System.out.println("Please enter email address: ");
        String email = in.nextLine();
        System.out.println("Please enter skype address: ");
        String skype = in.nextLine();
        UserDetails userDet = new UserDetails(name, home, mobile, email, skype);
        phoneBook.put(name, userDet);
    }

    private void findEntry(Map<String, UserDetails> phoneBook)
    {
        System.out.println("Please enter name to search for: ");
        String name = in.nextLine();
        if (phoneBook.containsKey(name)) {
            System.out.println(phoneBook.get(name));
        } else {
            System.out.println("No entry found.");
        }
    }

    private void removeEntry(Map<String, UserDetails> phoneBook)
    {
        System.out.println("Please enter name to remove: ");
        String name = in.nextLine();
        if (phoneBook.containsKey(name)) {
            System.out.println("Are you sure you would like to delete " + name);
            String ans = in.nextLine().toLowerCase();
            if (ans.charAt(0) == 'y') {
                phoneBook.remove(name);
                System.out.println("Entry removed");
            } else {
                System.out.println("Entry not removed");
            }
        } else {
            System.out.println("Entry does not exist to remove");
        }
    }
    
    
}
