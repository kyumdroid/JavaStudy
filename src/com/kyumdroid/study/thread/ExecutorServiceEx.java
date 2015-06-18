package com.kyumdroid.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future = executor.submit(new ExecutorServiceTask());
        
        Integer num = future.get();
        
        System.out.println(" do working..   main Thread");
        System.out.println(num);
    }

}

class ExecutorServiceTask implements Callable<Integer>
{
    public Integer call() throws InterruptedException
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(" do working..   new Thread : " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
        return  20;
    }
}