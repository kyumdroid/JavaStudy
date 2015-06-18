package com.kyumdroid.study.thread;

public class SynchronizeEx
{

    public static void main(String[] args)
    {
        
        
        Counter counter = new Counter();
        new SynchronizeThread(counter).start();
        new SynchronizeThread(counter).start();
        new SynchronizeThread(counter).start();
        new SynchronizeThread(counter).start();
    }

    private static void print(String msg)
    {
        System.out.println(msg);
        
    }
    
    

}


class SynchronizeThread extends Thread
{
    Counter counter;
    
    public SynchronizeThread(Counter counter)
    {
        this.counter = counter;
    }
    
    
    
    @Override
    public void run()
    {
        System.out.println("run()");
        
        for(int i = 0; i < 100; i++)
        {
            synchronized(counter)
            {
                counter.up();
                try{Thread.sleep(10); } catch(Exception e){}
                counter.down();
                System.out.println(counter.count);
            }
        }
    }
}