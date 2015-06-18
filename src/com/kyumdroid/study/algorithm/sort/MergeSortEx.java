package com.kyumdroid.study.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Sort(병합 정렬)
 * 설명 : 전체 리스트를 재귀적으로 두 개로 계속 나누어 하나의 단위로 분할 한 후 분할한 원소를 다시 병합하면서 정렬하는 방식이다.
 * 
 * 특징 : 성능은 O(nlogn)이고, 병합 시간은 O(n)이다. 재귀 호출은 리스트 크기의 1/2 만큼 발생한다.
 * 
 *
 */

public class MergeSortEx
{
    public static void main(String[] args)
    {      
      List<Integer> numbers  = mergeSort(Arrays.asList(new Integer[]{6,2,17,3,4 }));
  
      for(int num : numbers)
      {
          System.out.print(num +", ");
      }
    }
    
    public static List<Integer> mergeSort(final List<Integer> numbers)
    {
        if(numbers.size() < 2) return numbers;
        
        List<Integer> leftList = numbers.subList(0, numbers.size()/2);
        List<Integer> rightList = numbers.subList(numbers.size()/2, numbers.size());
        
        final List<Integer> mergedList = merge(mergeSort(leftList),mergeSort(rightList));
        return mergedList;
    }
    
    public static List<Integer> merge(final List<Integer> leftNumbers, final List<Integer> rightNumbers)
    {
        int leftPtr = 0;
        int rightPtr = 0;
        
        int leftSize = leftNumbers.size();
        int rightSize = rightNumbers.size();
        
        final List<Integer> mergedList = new ArrayList<>(leftSize + rightSize);
        
        while((leftPtr < leftSize) && (rightPtr < rightSize))
        {
            if(leftNumbers.get(leftPtr) < rightNumbers.get(rightPtr))
            {
                mergedList.add(leftNumbers.get(leftPtr));
                leftPtr++;
            }
            else
            {
                mergedList.add(rightNumbers.get(rightPtr));
                rightPtr++;
            }
        }
        
        while(leftPtr < leftSize)
        {
            mergedList.add(leftNumbers.get(leftPtr));
            leftPtr++;
        }
        
        while(rightPtr < rightSize)
        {
            mergedList.add(rightNumbers.get(rightPtr));
            rightPtr++;           
        }
        
        return mergedList;
    }
}


















