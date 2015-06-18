package com.kyumdroid.study.thread;

public class Counter
{
    public static int count = 0;
    
    public void up()
    {
        count++;
        //System.out.println(count);
    }
    
    public void down()
    {
        count--;
        ///System.out.println(count);
    }

    
    public synchronized void testA()
    {
        
    }
    
    public void SameCodetestA()
    {
        synchronized(this)
        {
            
        }
    }
    
    
    
    public static synchronized void testB()
    {
        
    }
    
    public void SameCodetestB()
    {
        synchronized(this.getClass())
        {
            
        }
        
    }
    
}
