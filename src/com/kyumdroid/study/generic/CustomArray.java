package com.kyumdroid.study.generic;

public class CustomArray
{
    public static <T extends Comparable> T getMax(T[] a)
    {
        if(a == null || a.length == 0)
        {
            return null;
        }
        
        T largest = a[0];
        int length = a.length;
        for(int i =0; i< length; i++)
        {
            if(largest.compareTo(a[i]) < 0)
            {
                largest = a[i];
            }
        }
        return largest;
    }
    
    
    public static void main(String[] args)
    {
        //Ex1
        String[] name = {"test","item", "value"};
        System.out.println("max : " + CustomArray.<String>getMax(name));
      
        
        //Ex2
        Integer[] num = new Integer[]{10,40,3 };//new Integer(10),new Integer(10),new Integer(10)};
        System.out.println("max : " + CustomArray.<Integer>getMax(num));
    }

}
