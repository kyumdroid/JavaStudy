package com.kyumdroid.study.algorithm.sort;


/**
 *  Selection Sort (선택 정렬) 
 *
 *  설명 : 원소 수 만큼 반복문을 돌면서 가장 작은 수를 찾아 앞으로 보내면서 정렬하는 방식이다. 
 *         첫번째 원소부터 반복문을 돌아서 가장 작은 수는 첫번째 원소와 교환한다.
 *         두번째 원소부터 반복문을 돌아서 가장 작은 수를 두번째 원소와 교환한다.
 *         ..
 *          
 *
 */
public class SelectionSortEx
{
    public static void main(String[] args)
    {
      int[] numbers = {6,2,17,3,4};
      sort(numbers);
      
//      List<Integer> numbers  = sort(Arrays.asList(new Integer[]{6,2,70,3,4,1,5}));
  
      for(int num : numbers)
      {
          System.out.print(num +", ");
      }
    }

    
    public static void sort(int[] numbers)
    {
        int length = numbers.length;
        int min = 0;
        int temp;
        
        for(int i = 0; i < length - 1; i++) // for(int i = 0; i < length-1; i++) ???
        {
            min = i;
            for(int j = i+1; j < length; j++)
            {
                if(numbers[j] < numbers[min])
                {
                    min = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
    }
}















