package com.kyumdroid.study.algorithm.cording.interview;

import java.util.HashMap;
import java.util.Map;

/**
 *  (문제) 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라. 
 *         다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 * 
 *   아스키코드 : 알파벳 26개와 확장 문자를 포함하여 총 256개를 넘지 않는 문자가 존재한다. (1byte는 -127~127 까지 총 2의 8승, 256개 이니 1byte로 된다.?? 2의 보수면 0~255까지)
 *                이는 1 바이트를 가지고 충분히 표현할 수 있기에 1 바이트의 char형을 사용해서 표현을 할 수 있다.
 *  
 *   유니코드 : 문자를 표현하는데 2 바이트를 사용해 총 65,536개의 문자를 표현할 수 있도록 정의해 놓은 문자셋이다.
 *  
 */
public class Exam0101
{
    public static void main(String[] args)
    {
        WordQualifier qualifier = new WordQualifier();
        
        System.out.println(qualifier.isValidWord("sfaegos"));
    }
}


class WordQualifier 
{
    private static Map<String,Boolean> map = new HashMap<>();  
    
    public static boolean isValidWord(String word)
    {
        if(word == null || word.length() > 256) return false;
        
        int length = word.length();
        for(int i = 0; i < length; i++)
        {
            final char c = word.charAt(i);
            if(map.containsKey(c + ""))
            {
                return false;
            }
            map.put(c + "", true);
        }
        return true;
    }
}







