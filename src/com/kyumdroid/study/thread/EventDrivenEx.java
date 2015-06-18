package com.kyumdroid.study.thread;

public class EventDrivenEx
{
    public static void main(String[] args)
    {
        MBuffer buffer = new MBuffer();
        (new Thread(new MProducer(buffer))).start();
        (new Thread(new MConsumer(buffer))).start();
    }

}

class MBuffer
{
    private int data;
    private boolean empty = true;
    
    
    public synchronized int get()
    {
        while(empty)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                
            }
        }
        empty = true;
        notifyAll();
        return data;
    }
    
    public synchronized void put(int data)
    {
        while(!empty)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                
            }
        }
        empty = false;
        this.data = data;
        notifyAll();
    }
}

class MProducer implements Runnable
{
    private MBuffer buffer;
    
    public MProducer(MBuffer buffer)
    {
        this.buffer = buffer;
    }
    
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            buffer.put(i);
            System.out.println("생상자 : " + i  + "번 케잌을 생산하였습니다.");
        
            try
            {
                Thread.sleep((int)(Math.random() * 100));
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
}


class MConsumer implements Runnable
{
    private MBuffer buffer;
    
    public MConsumer (MBuffer buffer)
    {
        this.buffer = buffer;
    }
    
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            //synchronized(buffer)
            {
                int data = buffer.get();
                System.out.println("소비자 : " + data + "번 케잌을 소비하였습니다.");
            }

        
            try
            {
                Thread.sleep((int)(Math.random() * 100));
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
}

