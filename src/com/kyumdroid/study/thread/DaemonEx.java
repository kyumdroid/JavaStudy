package com.kyumdroid.study.thread;

public class DaemonEx
{

    public static void main(String[] args)
    {
        print("start main");
        
        Thread th = new Thread(new MyDaemonRunnable());
        th.setDaemon(true);   //데몬 쓰레드로 지정하면 메인쓰레드가 종료시 데몬 쓰레드도 같이 종료한다.
        th.start();
        
        print("end main");
    }
    
    private static void print(String msg)
    {
        System.out.println(msg);
    }
    
}

class MyDaemonRunnable implements Runnable
{
    @Override
    public void run()
    {
        try{ Thread.sleep(1000); } catch(Exception e){}
        
        System.out.println("run()");
    }
}