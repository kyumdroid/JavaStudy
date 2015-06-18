package com.kyumdroid.study.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  (문제 1) : 1에서 n까지의 피보나치 수열을 반환하는 메소드를 작성하라. (메소드 : public static List<Integer> fibonacci(int n))
 *  피보나치 수열 :  앞의 두 수의 합이 바로 뒤의 수가 되는 수의 배열을 말한다. 
 *   0, 1, 1, 2, 3, 5 , 8, 13 ...
 * 
 * 
 *  (문제 2) : 피보나치 수열의 n번째 값을 반환하는 메소드를 작성하라. (메소드 : public static int fibN(int n))
 *  예 : 4번째 피보나치 수열은 2이다.
 * 
 */
public class FibonacciEx
{
    public static void main(String[] args)
    {
        final List<Integer> list = FibonacciEx.fibonacci(10);
        
        for(Integer num : list)
        {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        
        System.out.println("1. find : " + FibonacciEx.fibN(30));
        System.out.println("2. find : " + FibonacciEx.recusiveFibN(30));
        System.out.println("3. find : " + FibonacciEx.cachedRecusiveFibN(30));
        
    }

    /** (문제1)  */
    public static List<Integer> fibonacci(int n)
    {
        if(n <= 0) throw new IllegalArgumentException("n <= 0.. failed");
        
        if(n == 1)
        {
            return Arrays.asList(0);
        }
        else if(n == 2)
        {
            return Arrays.asList(0,1);
        }
    
        final List<Integer> resultList = new ArrayList<Integer>();
        resultList.add(0);
        resultList.add(1);
        for(int i = 2; i < n; i++)
        {
            resultList.add(resultList.get(i - 1) + resultList.get(i - 2));
        }
        return resultList;
    }
    
    /** (문제2) 방법 1 : (문제 1)에서 구현한 메소드를 호출한다. 하나의 값을 위해 전체 리스트를 만들어서
                             시간도 오래 걸리고 메모리 사용량도 많다. */
    public static int fibN(int n)
    {
        if(n <= 0) throw new IllegalArgumentException("n <= 0.. failed");
        final List<Integer> resultList = fibonacci(n);
        
        
        return resultList.get(resultList.size() - 1);
    }
    
    
    /** (문제2) 방법 2 :  재귀 호출을 하여 값을 가져온다. 같은 값의 매개변수를 가진 메소드를 또 부르게 되어
                               불필요한 계산 시간이 생긴다.*/
    public static int recusiveFibN(int n)
    {
        if(n <= 0) throw new IllegalArgumentException("n <= 0.. failed");
        
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        return recusiveFibN(n -1) + recusiveFibN(n-2);
    }
    
    
    private static Map<Integer, Integer> cache = new HashMap<>();
    
    /** (문제2) 방법 3 :  한번 계산된 값이면 캐시로 저장해서 동일한 값의 계산 시간을 줄였다. */
    public static int cachedRecusiveFibN(int n)
    {
        if(n <= 0) throw new IllegalArgumentException("n <= 0.. failed");
        
        cache.put(1, 0);
        cache.put(2, 1);
        
        return cachedFibN(n);
    }
    
    
    private static int cachedFibN(int n)
    {
        if(n < 0) return 0;
        
        if(cache.containsKey(n))
        {
//            System.out.println("cache.containsKey(" + n +") " + ", cache.get(n) : " + cache.get(n));
            return cache.get(n);
        }
        
        int result = cachedFibN(n - 1) + cachedFibN(n - 2);
        cache.put(n, result);
        return result;
    }
    
}
