package com.kyumdroid.study.algorithm.problem;

/**
 *  (문제) 재귀적 방법을 사용하지 않고 팩토리얼을 구현하라.
 * 
 *  팩토리얼 : 1부터 어떤 양의 정수 n까지의 정수를 모두 곱한 것을 말하며 n!로 나타낸다. 0!=1로 약속한다.
 *
 */
public class FactorialEx
{
    public static void main(String[] args)
    {
        System.out.println("FactorialEx.factorial(2) : " + FactorialEx.factorial(2));
    }

    
    public static long factorial(int n)
    {
        if(n < 0) throw new IllegalArgumentException("if n < 0..  failed");
        
        long result = 1;
        for(int i =1; i <= n; i++)
        {
            result *= i; 
        }
        return result;
    }
    
}
