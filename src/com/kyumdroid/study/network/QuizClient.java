package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient
{
    public static void main(String[] args) throws IOException
    {
        Socket quizSocket = null;
        
        PrintWriter out = null;
        BufferedReader in = null;
        
        try
        {
            //quizSocket = new Socket("localhost", 5555);
            quizSocket = new Socket("192.168.43.163", 5555);
            out = new PrintWriter(quizSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));
            
            
            
        }
        catch(UnknownHostException e)
        {
            System.err.println("localhost에 접근할 수 없습니다.");
            System.exit(1);
        }
        
        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        
        String fromServer;
        String fromUser;
        
        while((fromServer = in.readLine()) != null)
        {
            System.out.println("서버 : " + fromServer);
            if(fromServer.equals("quit"))
            {
                break;
            }
            
            fromUser = user.readLine();
            
            if(fromUser != null)
            {
                System.out.println("클라이언트 : " + fromUser);
                out.println(fromUser);
            }
        }
        System.out.println("while 문 빠져 나옴");
        
//        if(out != null) try { out.close(); } catch(Exception e){}
//        if(in != null) try { in.close(); } catch(Exception e){}
        closeIgnoringException(out);
        closeIgnoringException(in);
       
        
/*        Socket clientSocket = null;
        try
        {
            clientSocket = serverSocket.
        }
        catch(IOException e)
        {
            
        }*/
    }
    
    private static void closeIgnoringException(Closeable c)
    {
        if(c != null)
        {
            try
            {
                c.close();
            }
            catch(IOException e)
            {
                
            }
        }
    }

}
