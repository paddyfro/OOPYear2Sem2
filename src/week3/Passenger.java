package week3;

public class Passenger implements Comparable<Passenger>
{
    private String name;
    private boolean priority;

    public Passenger(String name, boolean priority)
    {
        this.name = name;
        this.priority = priority;
    }
    
    @Override
    public String toString()
    {
        return (priority ? "Priority":"") + " " + name ;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isPriority()
    {
        return priority;
    }

    public void setPriority(boolean priority)
    {
        this.priority = priority;
    }

    @Override
    public int compareTo(Passenger o)
    {
      if(priority == o.priority)
      {
          return 0;
      }
      if(priority && !o.priority)
      {
          return -1;
      }
      return 1;
    }
}


