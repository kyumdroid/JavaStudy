package com.kyumdroid.study.algorithm.sort;

import java.util.Arrays;
import java.util.List;

public class SortTest
{
    public static void main(String[] args)
    {
        List<Integer> numbers  = insertSort(Arrays.asList(new Integer[]{6,2,17,3,4}));
        
        
        for(int num : numbers)
        {
            System.out.print(num +", ");
        }
    }
    
    
    public static List<Integer> insertSort(final List<Integer> numbers)
    {
        int temp = 0;
        int size = numbers.size();
        
        for(int i = 1; i < size; i++)
        {
            temp = numbers.get(i);
            for(int j = i; j > 0 ; j--)
            {
                if(temp > numbers.get(j - 1)) break;
                
                numbers.set(j,numbers.get(j - 1));
                numbers.set(j - 1,temp);
            }
        }
        return numbers;
    }
    
    public static List<Integer> selectionSort(final List<Integer> numbers)
    {
        
        int size = numbers.size();
        int min = 0;
        int temp = 0;
        
        for(int i = 0; i < size - 1; i++)
        {
            min = i;
            for(int j = i; j < size; j++)
            {
                if(numbers.get(min) > numbers.get(j))
                {
                    min = j;
                }
            }
            
            if(i != min)
            {
                temp = numbers.get(i);
                numbers.set(i,numbers.get(min));
                numbers.set(min,temp);
            }
        }
        
        return numbers;
    }

}
