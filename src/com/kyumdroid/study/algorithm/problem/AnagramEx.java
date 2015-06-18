package com.kyumdroid.study.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  문제) 주어진 단어 리스트로 애너그램 리스트를 만들고, 특정 단어에 대해 애너그램 리스트를 반환하도록 구현하라. 
 *    
 *  애너그램(Anagram) : 서로 다른 문자열이지만, 문자를 재배치하면 동일한 문자가 되는 것으로 철자 순서를 바꾼 단어를 가리킨다.  
 *
 */
public class AnagramEx
{
    private Map<String, List<String>> mLookUp = new HashMap<>();
    
    public AnagramEx(final List<String> words)
    {
        for(String word : words)
        {
            final String key = alphabetize(word);
            if(mLookUp.containsKey(key))
            {
                mLookUp.get(key).add(word);
            }
            else
            {
                final List<String> anagramList = new ArrayList<String>();
                anagramList.add(word);
                mLookUp.put(key, anagramList);
            }
        }
    }
    
    
    private String alphabetize(final String word)
    {
        final byte[] alphabets = word.getBytes();
        Arrays.sort(alphabets);
        return new String(alphabets);
    }

    
    public List<String> getAnagramList(final String word)
    {
        final String key = alphabetize(word);
        final List<String> anagram = mLookUp.get(key);
        return (anagram == null)? new ArrayList<String>() : anagram; 
    }

    
    public static void main(String[] args)
    {
        AnagramEx anagram = new AnagramEx(Arrays.asList(new String[]{"item","data","list","sort","love","apple", "taad","leppa","orst"}));
        final List<String> anagramList = anagram.getAnagramList("stro");
        
        for(String word : anagramList)
        {
            System.out.println("word : " + word);
        }
    }
}
