package com.kyumdroid.study.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorEx
{
    public static void main(String[] args)
    {
        final Executor executor = Executors.newCachedThreadPool();
        executor.execute(new ExecutorTask());
        executor.execute(new ExecutorTask());
        executor.execute(new ExecutorTask());
        
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


class ExecutorTask implements Runnable
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


