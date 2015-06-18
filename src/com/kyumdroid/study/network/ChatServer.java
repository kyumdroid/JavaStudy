package com.kyumdroid.study.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ChatServer
{
    LinkedList<ChatClientHandler> clientList;
    
    String[] args;
    
    public ChatServer(String[] args)
    {
        this.args = args;
        clientList = new LinkedList<ChatClientHandler>();
    }

    public void runServer()
    {
        int port = Integer.parseInt(args[0]);
        
        ServerSocket server;
        try
        {
            server = new ServerSocket(port);
        }
        catch(IOException e)
        {
            System.err.println("Couldn't run server on port " + port);
            return;
        }
        
        while(true)
        {
            try
            {
                System.out.println("Wait for Request.. ");
                Socket connection = server.accept();
                System.out.println("Request arrived.. ");
                
                ChatClientHandler handler = new ChatClientHandler(connection,this);
                synchronized(clientList)
                {
                    clientList.add(handler);
                }
                
                new Thread(handler).start();
            }
            catch(IOException e)
            {
                
            }
        }
    }
    
    
    void broadcast(String message)
    {
        int size = clientList.size();
        for(int i =0; i < size; i++)
        {
            ChatClientHandler client = clientList.get(i);
            client.sendMessage(message);
        }
    }
    
    
    void removeClient(ChatClientHandler deadClient)
    {
        synchronized(clientList)
        {
            clientList.remove(deadClient);
        }
    }
    
    
    public static void main(String[] args)
    {
        new ChatServer(args).runServer();
    }

}
