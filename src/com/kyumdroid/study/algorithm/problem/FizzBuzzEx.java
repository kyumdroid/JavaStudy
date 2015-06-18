package com.kyumdroid.study.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 *  문제 : 1에서 n까지 숫자를 출력하되 3의 배수는 Fizz라는 문자열을 출력하고, 5의 배수는 Buzz라는 문자열을 출력하고,
 *         15의 배수는 FizzBuzz라는 문자열을 출력하는 알고리즘을 작성하라.
 * 
 *
 */
public class FizzBuzzEx
{
    public static void main(String[] args)
    {
        FizzBuzzEx FizzBuzz = new FizzBuzzEx();
        
//        List<String> list = FizzBuzz.simpleWork(50);
        List<String> list = FizzBuzz.doGoodWork(50);
        
        for(String strNum : list)
        {
            System.out.print(strNum);
        }
    }
    
    /** 괜찮은 방법 */
    private List<String> doGoodWork(final int n)
    {
        final List<String> resultList = new ArrayList<>(n);
        String result;
        for(int i = 1; i <= n; i++)
        {
            result = toWord(i,3,"Fizz") + toWord(i,5,"Buzz");
            
            if(result.isEmpty())
            {
                resultList.add(i +"");
            }
            else
            {
                resultList.add(result);
            }
        }
        return resultList;
    }
    
    private  String toWord(int number, final int divisor, final String word)
    {
        return (number%divisor == 0) ? word : ""; 
    }
    
    
    
    /** 단순 방법 */
    private List<String> doSimpleWork(final int n)
    {
        final List<String> resultList = new ArrayList<>(n);
        
        for(int i = 1; i <= n; i++)
        {
            if(i%15 == 0)
            {
                resultList.add("FizzBuzz");
            }
            else if(i%3 == 0)
            {
                resultList.add("Fizz");
            }
            else if(i%5 == 0)
            {
                resultList.add("Buzz");
            }
            else
            {
                resultList.add(i + "");
            }
        }
        return resultList;
    }
}
