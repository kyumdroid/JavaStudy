package com.kyumdroid.study.algorithm.sort;

import java.util.Arrays;
import java.util.List;


/**
 *  Binary Search(이진 검색)
 *  
 *  설명 : 원소들을 반으로 나누어 중앙값을 기준으로 크기를 비교하여 원소를 찾아가는 방식으로 정렬된 리스트일 때 사용하는 한다. 
 * 
 *  특징 : 
 *
 */
public class BinartSearchEx
{
    public static void main(String[] args)
    {
        boolean result  = binarySearch(MergeSortEx.mergeSort(Arrays.asList(new Integer[]{6,2,70,3,4,1,5})), 7);
        System.out.println("result : " + result);
    }
    
    public static boolean binarySearch(final List<Integer> numbers, final Integer value)
    {
        if(numbers == null || numbers.isEmpty()) return false;
        
        int size = numbers.size();

        final Integer other = numbers.get(size/2);
        if(value.equals(other))
        {
            return true;
        }
        
        if(value < other)
        {
            return binarySearch(numbers.subList(0, size/2) , value);
        }
        else
        {
            return binarySearch(numbers.subList(size/2 + 1, size) , value);
        }
    }
}
