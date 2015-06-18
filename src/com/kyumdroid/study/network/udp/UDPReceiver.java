package com.kyumdroid.study.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver
{
    public static void main(String[] args) throws IOException
    {
        byte[] buf = new byte[256];
        
        DatagramSocket socket = new DatagramSocket(5000);
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);  //client를 기다리고 있음.
        System.out.println(new String(buf));
      
        socket.close();
    }

}
