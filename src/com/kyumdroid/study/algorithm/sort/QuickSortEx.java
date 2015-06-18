package com.kyumdroid.study.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  퀵 정렬(Quick Sort) 
 *  설명 : Array에서 가장 자리 또는 중앙에 있는 원소를 기준키(pivot)으로 잡고, pivot와 비교하여 작거나 같은 값이면 앞으로, 큰 값이면 뒤로 재배열하는 정렬 방식이다.
 *  작은 값을 갖는 데이터와 큰 값을 갖는 데이터를 분리해 가면 재배열한 서브 리스트를 같은 방법으로 재귀적으로 호출하면, 작은 값을 갖는 데이터와 큰 값을 갖는 데이터가 분리되면서 정렬된다.
 *  
 *  
 *  특징: 버블 정렬이나 삽입 정렬보다 효율적이다.
 *        원소들을 두개의 리스트로 분리하기 때문에 시간 복잡도는 O(n)이다.
 *        재귀 호출 횟수는 리스트 크기의 1/2만큼 발생한다. 
 *        평균적인 성능은 O(nlogn)이다. 
 *        최악의 경우에는 O(n^2)이다. 
 *        재귀 호출은 다른 정렬과는 독립적이면서 병려로 실행되는 것이 좋다.??
 *  
 */
public class QuickSortEx
{
    public static void main(String[] args)
    {
//        int[] numbers = {6,2,70,3,4,1,5};
//        sort(numbers);
        
        List<Integer> numbers  = quickSort(Arrays.asList(new Integer[]{6,2,17,3,4}));
    
        for(int num : numbers)
        {
            System.out.print(num +", ");
        }
    }

    public static void sort(int[] numbers)
    {
        if(numbers.length < 2) return;
            
        int pivot = numbers[0];
        int left = 1;
        int right = numbers.length - 1;
        
        while(left < right)
        {
            while((numbers[left] <= pivot ) && (left < right))
            {
                System.out.println("left : " + left + ", riht : " + right + ", pivot : " + pivot);
                System.out.println("numbers[left] : " + numbers[left] + ", numbers[right] : " + numbers[right]);
                
                left++;
            }
            System.out.println("첫번째 while 문 끝");
            
            while((numbers[right] > pivot ) && (left < right))
            {
                System.out.println("left : " + left + ", riht : " + right + ", pivot : " + pivot);
                System.out.println("numbers[left] : " + numbers[left] + ", numbers[right] : " + numbers[right]);
                right--;
            }
            System.out.println("두번째 while 문 끝");
            
            System.out.println("비교!!!! " + ", left : " + left + ", riht : " + right + ", pivot : " + pivot);
            System.out.println("numbers[left] : " + numbers[left] + ", numbers[right] : " + numbers[right]);
            
            if(left < right) 
            {
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                System.out.println("교환!!! " + numbers[left] + "와 " + numbers[right]);
            }
            else
            {
                
            }
            
        }
    }
    
    
    public static List<Integer> quickSort(List<Integer> numbers)
    {
        if(numbers.size() < 2) return numbers;
        
        
        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();
        
        for(int i = 1; i < numbers.size(); i++)
        {
            if(numbers.get(i) < pivot)
            {
                lower.add(numbers.get(i));
            }
            else
            {
                higher.add(numbers.get(i));
            }
        }
        
        final List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));
        
        return sorted;
    }
}



















