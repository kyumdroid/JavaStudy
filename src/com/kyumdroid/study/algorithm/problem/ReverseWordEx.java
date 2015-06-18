package com.kyumdroid.study.algorithm.problem;


/**
 * (문제) 문자열을 뒤집기 위한 메소드를 구현하라.
 *
 */
public class ReverseWordEx
{
    public static void main(String[] args)
    {
//        System.out.println(reverse("word"));
        
        System.out.println(reverseWord("word"));
    }
    
    /** 방법1 */
    public static String reverse(final String word)
    {
        int length = word.length();
        
        final StringBuilder builder = new StringBuilder(length);
        for(int i = length - 1; i >= 0; i--)
        {
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }
    
    
    /** 방법2 */
    public static String reverseWord(final String word)
    {
        int length = word.length();
        
        final StringBuilder builder = new StringBuilder(word);
        for(int i = 0; i < length/2; i++)
        {
            final char temp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(length - 1 - i));
            builder.setCharAt(length - 1 - i,temp);
        }
        return builder.toString();
    }
}
