package com.kyumdroid.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler implements Runnable
{
    private Server mServer;
    private Socket mConnection;
    
    private BufferedReader mReader;
    private PrintWriter mWriter;
    
    private String mName;
    
    public Handler(Server server, Socket connection){
       mServer = server;
       mConnection = connection;
       
       try
       {
           mReader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
           mWriter = new PrintWriter(new OutputStreamWriter(mConnection.getOutputStream()));

           mName = mReader.readLine();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public void run(){
        try
        {
            while(true){
              String msg = mReader.readLine();
              mServer.broadcast(mName + ":" + msg);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace(); 
            mServer.removeHandler(this);
        }
    }
    
    public void sendMessage(String msg){
        mWriter.println(msg);
        mWriter.flush();
    }
}
