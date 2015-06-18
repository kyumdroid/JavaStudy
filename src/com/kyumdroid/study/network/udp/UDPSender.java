package com.kyumdroid.study.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender
{

    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = new DatagramSocket();
        
        String s = "UDP 데이터 테스트 중입니다.";
        byte[] buf = s.getBytes();
        
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buf,buf.length,address,5000);
        socket.send(packet);
        socket.close();
        
    }

}
