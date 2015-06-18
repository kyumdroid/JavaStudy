package com.kyumdroid.study.reference;

import java.util.ArrayList;
import java.util.List;

public class StrongReferenceEx
{
    public static void main(String[] args)
    {
        MemoryLeakStack<String> stack = new MemoryLeakStack<String>();
        
        stack.push("item");
        stack.push("data");
        
        stack.pop();
        stack.pop();
    }
}


class MemoryLeakStack<E>
{
    private final List<E> stack;
    private int pointer;
    
    public MemoryLeakStack()
    {
        stack = new ArrayList<>();
        pointer = 0;
    }
    
    public void push(E element)
    {
        stack.add(pointer, element);
        pointer++;
    }
    
    public E pop()
    {
        if(pointer <= 0) return null;
        
        pointer--;
        return stack.get(pointer);
    }
}