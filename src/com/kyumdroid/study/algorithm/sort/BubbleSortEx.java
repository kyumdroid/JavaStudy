package com.kyumdroid.study.algorithm.sort;

/**
 *  버블 정렬(Bubble Sort)
 *  설명 : 왼쪽부터 인접한 데이터들을 비교하여, 큰 데이터를 오른쪽으로 보내는 정렬방식이다. 
 *  특징 : 테스트 해봐야함. 
 *         정렬이 된 상태임에도 불구하고 마지막까지 비교해야 함으로 비효율적이다. 
 *         최악의 경우 역순으로 정렬되어 있다면, O(n^2)의 성능을 낸다. 왜냐하면, 순환할때 하나의 원소만 변경하기 때문이다.
 *         최선의 경우에는 이미 정렬되어 있을때이다.  순환할때 원소의 위치를 변경하지 않아도 되기 때문에 O(n)의 성능을 낸다.
 *
 */

public class BubbleSortEx
{
    public static void main(String[] args)
    {
        int[] numbers = { 6,2,17,3,4 };
        sort(numbers);

        System.out.print("방법 1 : ");
        for (int num : numbers)
        {
            System.out.print(num + ", ");
        }
        System.out.println("");
       
        
        int[] numbers2 = { 6,2,17,3,4};
        bubbleSort(numbers2);
        
        System.out.print("방법 2 : ");
        for (int num : numbers2)
        {
            System.out.print(num + ", ");
        }
    }

    public static void sort(int[] numbers)
    {
        int count = 0;
        
        int temp;
        boolean isChangedNumber;
        int length = numbers.length;

        do
        {
            isChangedNumber = false;
            for (int i = 0; i < length - 1; i++)
            {
                if (numbers[i + 1] < numbers[i])
                {
                    count ++;
                    
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    isChangedNumber = true;
                }
            }
        } while (isChangedNumber);
        
        System.out.println("count : " + count);
    }

    public static void bubbleSort(int[] numbers)
    {
        int count = 0;
        
        int temp;
        boolean isChangedNum;
        int length = numbers.length;
        
        for(int j = length -1; j > 0; j-- )
        {
            isChangedNum = false;
            for(int i = 0; i < length -1; i++)
            {
                count ++;
                
                if(numbers[i] > numbers[i + 1])
                {
                    temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    isChangedNum = true;
                }
            }
            if(isChangedNum == false) break;
        }
        
        System.out.println("count : " + count);
    }

}
