package week3;



public class Task implements Comparable<Task>
{
    private int priority;
    private String description;

    public Task(int priority, String description)
    {
        this.priority = priority;
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Task{" +" description=" + description + ", priority=" + priority +  '}';
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int compareTo(Task o)
    {
        return priority - o.getPriority();
    }
    
    
}