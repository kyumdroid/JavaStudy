package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient
{
    private BufferedReader reader;
    private PrintWriter writer;
    
    public ChatClient(String[] args)
    {
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        
        Socket connection = null;
        try
        {
            connection = new Socket(hostname, port);    
        }
        catch(IOException e)
        {
            System.err.println("Connection failed");
            return;
        }
        
        try
        {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
        
            writer.println(args[2]);
            
            new Thread(new ChatClientReader()).start() ;
            
            
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            
            String myMsg;
            while((myMsg = user.readLine()) != null)
            {
                writer.println(myMsg);
                writer.flush();
            }
        
        }
        catch(IOException e)
        {
            e.printStackTrace(); 
        }
    }
    
    class ChatClientReader implements Runnable
    {
        public void run()
        {
            String msg; 
            try
            {
                while(true)
                {
                    msg = reader.readLine();    
                    System.out.println("[Msg from Server]" + msg);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace(); 
            }

            
        }
    }
    

    public static void main(String[] args)
    {
        new ChatClient(args);
    }

}
