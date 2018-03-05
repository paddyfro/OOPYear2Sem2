
// Student - used in Q7
package week3;

public class Student implements Comparable<Student>
{
    private String firstName;
    private String lastName;
    private int ID;
    private static int IDs = 0;

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        ID = IDs++;
    }
    
    @Override
    public int compareTo(Student o)
    {
       if(lastName.equals(o.lastName))
       {
           if(firstName.equals(o.firstName))
           {
               return ID - o.ID;
           }
           return firstName.compareTo(o.firstName);
       }
       return lastName.compareTo(o.lastName);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    @Override
    public String toString()
    {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", ID=" + ID + '}';
    }
    
}




