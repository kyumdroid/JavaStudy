package com.kyumdroid.study.algorithm.sort;

import java.util.LinkedList;
import java.util.List;

/**
 *  삽입 정렬(Insert Sort)
 *  설명 : 첫 번째 데이터를 정렬된 목록으로 간주하고, 두 번째 데이터부터 정렬된 앞 부분의 데이터와 비교하여
 *         삽입해 가는 정렬방식이다.
 *          
 *  특징 : 테스트 해야함..
 *        최악의 경우에는 이미 정렬된 리스트를 다시 정렬하는 경우에 리스트 끝까지 반복문을 돌기 때문에 O(n^2)의 성능을 낸다.??
 *        최선의 경우에는 역순으로 정렬되어 있으면, 앞에 있는 원소를 넣으므로 O(n)의 성능을 낸다?
 * 
 */



public class InsertSortEx
{

    public static void main(String[] args)
    {
        int[] numbers = {6,2,17,3,4};
        sort(numbers);
            
        //List<Integer> numbers  = insertSort(Arrays.asList(new Integer[]{6,2,17,3,4}));
        
        
        for(int num : numbers)
        {
            System.out.print(num +", ");
        }
    }

    /** 방법 1 */
    public static void sort(int[] numbers)
    {
        int count = 0;
        
        int temp;
        int length = numbers.length;
        for(int i = 1; i < length; i++)
        {
            temp = numbers[i];
            for(int j = i; j > 0; j--)
            {
                count ++;
                
                System.out.println(temp + "와 " + numbers[j-1] + " 비교");
                
                if(temp > numbers[j-1])  break;
                    
                numbers[j] = numbers[j -1];
                numbers[j -1] = temp;
            }
        }
        
        System.out.println("count : " + count);
    }
    
    
    /** 방법 2 */
    public static List<Integer> insertSort(final List<Integer> numbers)
    {
        int count = 0;
        
        final List<Integer> sortedList = new LinkedList<>();
        
        originalList : for(Integer number : numbers)
        {
            for(int i = 0; i < sortedList.size(); i++)
            {
                count ++;
                
                if(number < sortedList.get(i))
                {
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }
        
        System.out.println("count : " + count);
        
        return sortedList;
    }
}


































