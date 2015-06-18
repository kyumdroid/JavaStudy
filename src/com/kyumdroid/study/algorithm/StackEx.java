package com.kyumdroid.study.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;


/**
 * 스택은 삽입과 삭제가 한 쪽에서 이루어지는 리스트 구조로, 마지막에 추가된 항목이 제일 먼저 삭제된다. 
 * 
 * 배열, 동적 배열, 연결 리스트로 스택을 구현해보자.
 * 
 */
public class StackEx
{

    @Test
    public void ArrayStackTest()
    {
        ArrayStack stack =  new ArrayStack(2);

        stack.push(2);
        stack.push(3);
        
        
        assertTrue(stack.isFullStack());
        
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        
        assertTrue(stack.isEmptyStack());
        
    }
    
    
    @Test
    public void DynArrayStack()
    {
        DynArrayStack stack =  new DynArrayStack(2);

        stack.push(2);
        stack.push(3);
        assertEquals(stack.size(),2);
        
        stack.push(5);
        assertEquals(stack.size(),2*2);
        
        assertEquals(5, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        
        assertTrue(stack.isEmptyStack());
        
    }
    
    
    @Test
    public void LinkedListStack()
    {
        LinkedListStack<Integer> stack =  new LinkedListStack<Integer>();

        stack.push(2);
        stack.push(3);
        assertEquals(stack.size(),2);
        
        stack.push(5);
        assertEquals(stack.size(),3);
        
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        
        assertTrue(stack.isEmpty());
    }
}


/**
 *  배열로 스택을 구현할 때.. 
 *  한계 : 고정된 스택 크기, push,pop에 대한 예외처리..(?)
 *  
 */
class ArrayStack
{
    private int[] stacks;
    private int top = -1;
    private int capacity;
    
    public ArrayStack()
    {
        this(3);
    }
    
    public ArrayStack(int capacity)
    {
        stacks = new int[capacity];
        this.capacity = capacity;
    }
    
    
   public void push(int num)
   {
       if(isFullStack()) return;
       
       stacks[++top] = num;
   }
    
   public int pop()
   {
       if(isEmptyStack()) return 0;
       
       return stacks[top--];
   }
   
   public boolean isFullStack()
   {
       return (top == (capacity - 1));
      
   }
   
   public boolean isEmptyStack()
   {
       return (top < 0);
   }
   
   public int size()
   {
       return capacity;
   }
}

/**
 * 2배 확장으로인해 너무 많은 메모리 잡아 오버플로우가 발생할 수 있다.
 * 
 *
 */
class DynArrayStack
{
    private int[] stacks;
    private int top = -1;
    private int capacity;
    
    public DynArrayStack()
    {
        this(3);
    }
    
    public DynArrayStack(int capacity)
    {
        stacks = new int[capacity];
        this.capacity = capacity;
    }
    
    
   public void push(int num)
   {
       if(isFullStack())
       {
           expand();
       }
       
       stacks[++top] = num;
   }
    
   public int pop()
   {
       if(isEmptyStack()) return 0;
       
       return stacks[top--];
   }
   
   public boolean isFullStack()
   {
       return (top == (capacity - 1));
      
   }
   
   public boolean isEmptyStack()
   {
       return (top < 0);
   }
   
   public int size()
   {
       return capacity;
   }
   
   private void expand()
   {
       capacity *= 2;
       int[] newStack = new int[capacity];
       System.arraycopy(stacks, 0, newStack, 0, stacks.length);
       stacks = newStack;
   }
}

/**
 *  확장 및 축소가 부드럽다. 
 *  연산할 때, 참조를 위한 공간과 부가적인 시간이 필요하다.
 *
 */
class LinkedListStack<T>
{
    private Node head;
    
    public void push(T data)
    {
        if(head == null){
            head = new Node(data);
        }else{
            final Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }
    
    public T pop()
    {
        if(isEmpty()) throw new EmptyStackException();
        
        T data = head.getData();
        head = head.next;
        
        return data;
    }
    
    public boolean isEmpty()
    {
        return (head == null);
    }
    
    public int size()
    {
        if(head == null) return 0;
        
        int count = 0;
        Node curr = head;
        while(curr != null)
        {
            curr = curr.next;
            count++;
        }
        return count;
    }
    
    
    class Node
    {
        T data;
        Node next;
        
        public Node(T data)
        {
            this.data = data;
            next = null;
        }
        
        public T getData()
        {
            return data;
        }
    }
}


