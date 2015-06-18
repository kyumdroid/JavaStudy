package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = null;
        try
        {
            serverSocket = new ServerSocket(5555);
        }
        catch(IOException e)
        {
            System.out.println("다음의 포트 번호에 연결할 수 없습니다. 5555");
            System.exit(1);
        }
        
        Socket clientSocket = null;
        try
        {
            clientSocket = serverSocket.accept();
        }
        catch(IOException e)
        {
            System.out.println("accept() 실패");
            System.exit(1);
        }
        System.out.println("accept() 성공");
        
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine;
        String outputLine;
        
        QuizProtocol qp = new QuizProtocol();
        
        outputLine = qp.process(null);
        out.println(outputLine);
        
        while((inputLine = in.readLine()) != null)
        {
            System.out.println("클라이언트 : " + inputLine);
            
            outputLine = qp.process(inputLine);
            out.println(outputLine);
            if(outputLine.equals("quit"))
            {
                break;
            }
        }
        
        out.close();
        in.close();
        clientSocket.close();
        
    }

}
