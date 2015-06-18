package com.kyumdroid.study.algorithm.cording.interview;

/**
 * (문제) 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 *        가령 압축해야 할 문자열이 aabbcccccccaaa라면 a2b2c7a3과 같이 압축되어야 한다.
 *        압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래
 *        문자열을 그대로 반환해야 한다.
 */
public class Exam0105
{

    public static void main(String[] args)
    {
        System.out.println(compress("aabbcccccccaaa"));
        System.out.println(getCompressedWordLength("aabbcccccccaaa"));
    }
    
    
    public static String compress(final String origin)
    {
        if(origin == null) throw new NullPointerException();
        
        StringBuilder compressedList = new StringBuilder();
        
        int length = origin.length();
        int count = 1;
        for(int i = 0; i < length - 1; i++)
        {
            if(origin.charAt(i) == origin.charAt(i + 1))
            {
                count++;
            }
            else
            {
                compressedList.append(origin.charAt(i)).append(count);
                count = 1;
            }
        }
        compressedList.append(origin.charAt(length - 1)).append(count);
        
        return (origin.length() < compressedList.toString().length()) ? origin : compressedList.toString();
    }
    
    
    private static int getCompressedWordLength(String word)
    {
        if(word == null || word.isEmpty()) return 0;
        
        int length = word.length();
        int count = 0;
        for(int i = 0; i < length - 1; i++)
        {
            if(word.charAt(i) != word.charAt(i + 1))
            {
                count += 2;
            }
        }
        count += 2;
        
        return count;
    }
}


