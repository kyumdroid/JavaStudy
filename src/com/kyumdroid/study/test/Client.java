package com.kyumdroid.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    private BufferedReader mReader;
    private PrintWriter mWriter;
    
    
    public Client(String[] args){
    
        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        Socket connection = null;
        
        try
        {
            connection = new Socket(hostName,port);
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            mReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            mWriter = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
        
            mWriter.println(args[2]);
            
            new Thread(new ClientReader()).start();
            
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            
            String msg;
            while((msg = user.readLine()) != null){
                mWriter.println(msg);
                mWriter.flush();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    class ClientReader implements Runnable{
        @Override
        public void run(){
            String msg;
            
            try
            {
                while(true){
                    msg = mReader.readLine();
                    System.out.println("[message from server]" + msg);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        new Client(args);
    }

}


