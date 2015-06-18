package com.kyumdroid.study.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server
{
    private int port;
    private List<Handler> mClientHandler;
    
    public Server(String[] args){
        this.port = Integer.parseInt(args[0]);
        mClientHandler = new LinkedList<Handler>();
    }

    public void run(){
        ServerSocket server = null;
        
        try
        {
            server = new ServerSocket(port);
            
            System.out.println("Wait for Request.. ");
            Socket connection = server.accept();
            System.out.println("Request arrived.. ");
            
            Handler handler = new Handler(this,connection);            
            
            synchronized(mClientHandler){
                mClientHandler.add(handler);
            }
            new Thread(handler).start();
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void removeHandler(Handler handler){
        synchronized (mClientHandler)
        {
            mClientHandler.remove(handler); 
        }
    }
    
    public void broadcast(String msg){
        System.out.println("Broadcast.. to all clients  ");
        
        for(Handler client : mClientHandler){
            client.sendMessage(msg);
        }
    }
    
    public static void main(String[] args)
    {
        new Server(args).run();
    }

}
