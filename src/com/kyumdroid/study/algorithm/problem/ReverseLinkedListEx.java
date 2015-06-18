package com.kyumdroid.study.algorithm.problem;

import org.junit.Test;
import static org.junit.Assert.*;



/**
 * (문제) LinkedList의 순서를 뒤집는 메소드를 작성하라. (소스 교재 참고)
 *        
 * 
 */
public class ReverseLinkedListEx
{
    public static void main(String[] args)
    {
        new ReverseLinkedListEx().test();
    }
    
    @Test
    public void test()
    {
        final LinkedList<Integer> three = new LinkedList<Integer>(new Integer(3),null);
        final LinkedList<Integer> two = new LinkedList<Integer>(new Integer(2),three);
        final LinkedList<Integer> one = new LinkedList<Integer>(new Integer(1),two);
        
        final LinkedList<Integer> reverseList = LinkedList.reverse(one);
        
        assertEquals(new Integer(3), reverseList.getElement());
        assertEquals(new Integer(2), reverseList.getNext().getElement());
        assertEquals(new Integer(1), reverseList.getNext().getNext().getElement());
    }
}


class LinkedList<T>
{
    private T element;
    private LinkedList<T> next;
    
    
    public LinkedList(T element, LinkedList<T> next)
    {
        this.element = element;
        this.next = next;
    }
    
    
    public T getElement()
    {
        return element;
    }
    
    
    public LinkedList<T> getNext()
    {
        return next;
    }
    

    public static<T> LinkedList<T> reverse(final LinkedList<T> list)
    {
        if(list == null) throw new NullPointerException("List is null");
        
        if(list.getNext() == null)
        {
            return list;
        }
        
        final LinkedList<T> nextList = list.next;
        list.next = null;
        
        
        final LinkedList<T> reverseList = reverse(nextList);
        
        nextList.next = list;
        
        return reverseList;
    }
}



