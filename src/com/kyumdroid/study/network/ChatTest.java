package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ChatTest
{
  
}


class Server{
    
    LinkedList<Handler> clientList;
    
    String[] args;
    
    
    public Server(String[] args){
        this.args = args;
        clientList = new LinkedList<Handler>();
    }
    
    public void start(){
        int port = Integer.parseInt(args[0]);
        ServerSocket server;
        
        try{
            server = new ServerSocket(port);
        }catch(IOException e){
            //TODO : Log 남김
            return;
        }
        
        while(true){
            
            try{
              //기다르는거지..
                
              Socket connection = server.accept();
              //받음.. 핸들러에 넣음
              
              Handler handler = new Handler(connection,this);
              synchronized(clientList){
                clientList.add(handler);
              }
              new Thread(handler).start();
              
              
            }catch(IOException e){
                //TODO : LOG 남김
            }
        }
    }
    
    void broadcast(String msg){
        for(Handler handler : clientList){
            handler.sendMessage(msg);
        }
    }
    
    
    void removeClient(Handler client){
        synchronized(clientList){
            clientList.remove(client);
        }
    }
    
    
    
    public static void main(String[] args){
        new Server(args).start();
    }
}


class Client{
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String[] args){
        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        
        Socket connection = null;
        try{
            connection = new Socket(hostName,port);
        }
        catch(IOException e){
            return;
        }
        
        try{
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
            
            writer.println(args[2]);
            
            new Thread().start();
            
            
            
        }catch(IOException e){
            
        }
    }
    
    class ClientReader implements Runnable{
        @Override
        public void run(){
            String msg;
            try{
                while(true){
                    msg = reader.readLine();
                }
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    
}



class Handler implements Runnable{
    private Socket connection;
    private BufferedReader reader;
    private PrintWriter writer;
    
    private String name;
    
    private Server server;
    
    public Handler(Socket connection, Server server ){
        this.connection = connection;
        this.server = server;
        
        try{
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
            
            name = reader.readLine();
            
        }catch(IOException e){
            
        }
    }
    
    @Override
    public void run(){
        try{
            while(true){
                String msg = reader.readLine();
            }
        }catch(IOException e){
            server.removeClient(this);
        }
    }

    void sendMessage(String msg){
        writer.println(msg);
        writer.flush();
    }
}















