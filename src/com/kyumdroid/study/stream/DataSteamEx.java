package com.kyumdroid.study.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataSteamEx
{

    public static void main(String[] args) throws IOException
    {
        DataOutputStream out = null;
        DataInputStream in = null;
        
        
        out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
        out.writeInt(34);
        out.writeDouble(100);
        out.writeUTF("테스트 중입니다.");
        out.flush();
        
        
        in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
        
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        
        
        if(in != null) in.close();
        if(out != null) out.close();
    }

}
