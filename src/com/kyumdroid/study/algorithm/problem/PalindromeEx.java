package com.kyumdroid.study.algorithm.problem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;


/**
 * (문제) 단어가 팰린드롬인지 확인하는 메소드를 구현하라.
 *   
 *   팰린드롬 : 문자열을 반대로 배열해도 동일한 문자나 문장이 되는 것.
 *  
 * 
 */
public class PalindromeEx
{
    @Test
    public void test()
    {
        assertTrue(isPalindromes("wo  o  w"));
        assertFalse(isPalindromes("wo  soa  w"));
    }
    
    
    /** 방법1  좋아보이진 않는다.*/
    public static boolean isPalindromes(final String word)
    {
        StringBuilder builder = new StringBuilder();
    
        int length = word.length();
        for(int i = 0; i < length; i++)
        {
            if(word.charAt(i) != ' ')
            {
                builder.append(word.charAt(i));
            }
        }
        
        boolean result = true;
        
        int size = builder.length();
        for(int i = 0; i < size/2; i++)
        {
            if(builder.charAt(i) != builder.charAt(size - 1 - i))
            {
                result = false;
                break;
            }
        }
        return result;
    }
    
    
    /** 방법 2 */
    public static boolean isPalindrome(final String str)
    {
        final String word = str.toLowerCase();
        int leftPosition = 0;
        int rightPosition = word.length() - 1;
        int strLength = word.length();
       
        while(leftPosition <= rightPosition)
        {
            while(leftPosition < strLength && !Character.isLetter(word.charAt(leftPosition)))
            {
                leftPosition ++;
            }
            
            while(rightPosition > 0 && !Character.isLetter(word.charAt(rightPosition)))
            {
                rightPosition --;
            }
            
            if(leftPosition > strLength || rightPosition < 0) return false ;
            
            if(word.charAt(leftPosition) != word.charAt(rightPosition)) return false ;
            
            
            leftPosition ++;
            rightPosition ++;
        }
        return true;
    }
}
