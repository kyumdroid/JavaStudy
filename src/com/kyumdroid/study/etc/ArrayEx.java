package com.kyumdroid.study.etc;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class ArrayEx
{
    public static void main(String[] args)
    {
        final List<String> list = new ArrayList<String>();
        list.add("item");
        list.add("data");
        list.add("value");
        
        String[] array = toArrayFromList(list);
        
        for(String value : array)
        {
            System.out.println(value);
        }
    }
    
    public static String[]  toArrayFromList(final List<String> list)
    {
//      return (String[])list.toArray(); -> ClassCastException 발생
        
        return (String[])list.toArray(new String[list.size()]);
    }
}
