package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientHandler implements Runnable
{
    private Socket connection;
    private BufferedReader reader;
    private PrintWriter writer;
    
    private ChatServer server;
    
    private String myName;
    
    
    public ChatClientHandler(Socket connection, ChatServer server)
    {
        this.connection = connection;
        this.server = server;
        
        try
        {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
       
            myName = reader.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                String msg = reader.readLine();
                server.broadcast(myName + ":" + msg);
            }
           
            
            
//            System.out.println("Received : " + clientName);
//            writer.println("Hello " + clientName);
//            writer.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace(); 
            server.removeClient(this);
        }
    }

    
    void sendMessage(String msg)
    {
        writer.println(msg);
        writer.flush();
    }
    
    
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }
}
