package com.kyumdroid.study.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamEx
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        
        out = new ObjectOutputStream(new FileOutputStream("object.txt"));
        out.writeObject(new Item("kyum",30));
        out.flush();
        
        
        in = new ObjectInputStream(new FileInputStream("object.txt"));
        Item item = (Item)in.readObject();
        System.out.println("name : " + item.name);
        System.out.println("number : " + item.number);
        
        
        if(in != null) in.close();
        if(out != null) out.close();
        
    }
    
    

}

class Item implements Serializable
{
    public String name;
    public int number;
    
    public Item(String name, int number)
    {
        this.name = name;
        this.number = number;
    }
    
}
