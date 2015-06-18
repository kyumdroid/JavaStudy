package com.kyumdroid.study.thread;

public class JoinEx
{

    public static void main(String[] args)
    {
        print("start main");
        
        Thread th = new Thread(new MyThread());
        th.start();
        
        try
        {
            th.join();    //th 쓰레드가 종료되기 전에 main 쓰레가 종료되지 않고 기다린다.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        
        print("end main");
    }

    private static void print(String msg)
    {
        System.out.println(msg);
    }

}

class MyThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("run() ");
    }
}
