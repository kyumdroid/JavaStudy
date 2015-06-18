package com.kyumdroid.study.etc;

import java.util.Date;

public class ShutdownHookEx
{
    public static void main(String[] args) throws InterruptedException
    {
        
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.err.println("Shut down JVM " + new Date());
            }
        });
        
        System.out.println("start main");
        Thread.sleep(2000);
        
        System.out.println("exit main");
        System.exit(0);
        
        Thread.sleep(3000);
        System.out.println("end main");
    }
}
