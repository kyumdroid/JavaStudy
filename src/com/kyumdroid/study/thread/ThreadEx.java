package com.kyumdroid.study.thread;

public class ThreadEx
{
    public static void main(String[] args)
    {
        final Thread subThread = new Thread(new ThreadTask());
        subThread.start();
        
        for(int i = 0; i < 3; i++)
        {
            System.out.println(" do working..   main Thread : " + Thread.currentThread().getName());
            
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class ThreadTask implements Runnable
{
    @Override
    public void run()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(" do working..   new Thread : " + Thread.currentThread().getName());
            
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}