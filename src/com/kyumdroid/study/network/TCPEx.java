package com.kyumdroid.study.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 네트워크 프로그래밍을 위한 패키지 jave.net
 * 
 * TCP를 위한 클래스
 * URL, URLConnection, Socket, ServerSocket
 * 
 * 
 */

public class TCPEx
{

    public static void main(String[] args) throws Exception
    {
        URLEx urlEx = new URLEx();
        urlEx.test();

    }
}

class URLEx
{
    public void test() throws Exception
    {
        URL myurl = new URL("http://www.naver.com");
        
        URLConnection connection = myurl.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        String inLine;
        
        while((inLine = br.readLine()) != null)
        {
            System.out.println(inLine);
        }
        br.close();
    }
}

class SocketEx
{
    public void test() throws Exception
    {
    
    }
}

