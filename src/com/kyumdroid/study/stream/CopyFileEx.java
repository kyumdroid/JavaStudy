package com.kyumdroid.study.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyFileEx
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = null;
        PrintWriter out = null;
        
        out = new PrintWriter(new FileWriter("output.txt"));
        out.println("testtest");
        out.println("testtest");
        out.println("testtest");
        out.println("testtest");
        out.println("testtest");
        out.flush();
        
        in = new BufferedReader(new FileReader("output.txt"));
        String result;
        
        while((result = in.readLine()) != null)
        {
            System.out.println(result);
        }
        
        
        if(in != null ) in.close();
        if(out != null ) out.close();
        
        
        
    }

}
