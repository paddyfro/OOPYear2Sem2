/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

/**
 *
 * @author patri
 */
public class WorkOrder implements Comparable
{
    private int priority;
    private String job;

    public WorkOrder(int priority, String job)
    {
        this.priority = priority;
        this.job = job;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    @Override
    public String toString()
    {
        return "WorkOrder{" + "priority=" + priority + ", job=" + job + '}';
    }

    @Override
    public int compareTo(Object o)
    {
        WorkOrder other = (WorkOrder) o;
        
        return this.priority - other.priority;
    }
    
    
    
}
