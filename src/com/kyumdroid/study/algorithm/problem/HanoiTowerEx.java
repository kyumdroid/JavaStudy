package com.kyumdroid.study.algorithm.problem;


/**
 *  하노이의 탑 퍼즐에 대해 논의하라.
 * 
 *  참고 : http://blog.naver.com/sunho1026/220314531226
 *
 */
public class HanoiTowerEx
{
    public static void main(String[] args)
    {
        hanoi(3,'A','B','C');
    }

    public static void hanoi(int n, char from, char to, char aux)
    {
        if(n == 1)
        {
            System.out.println("from : " + from + ", to : " + to);
            return;
        }
        
        hanoi(n-1,from,aux,to);
        
        System.out.println("from : " + from + ", to : " + to);
        
        
        hanoi(n-1,aux, to , from);
    }
}
