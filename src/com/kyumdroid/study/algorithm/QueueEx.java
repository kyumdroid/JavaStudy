package com.kyumdroid.study.algorithm;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * 원형 배열, 동적 원형 배열, 연결 리스트로 큐를 구현하자.
 * 
 *
 */
public class QueueEx
{
    @Test
    public void ArrayQueueTest()
    {
        ArrayQueue queue = new ArrayQueue(3);
        
        queue.enQueue(3);
        queue.enQueue(5);
        assertEquals(2,queue.size());
        
        assertEquals(3,queue.deQueue());
        assertEquals(1,queue.size());
        
        queue.deQueue();
        assertTrue(queue.isEmpty());
        
        
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        assertEquals(3,queue.size());
    }
    
    @Test
    public void DynArrayQueueTest()
    {
        DynArrayQueue queue = new DynArrayQueue(3);
        
        queue.enQueue(3);
        queue.enQueue(5);
        assertEquals(2,queue.size());
        
        assertEquals(3,queue.deQueue());
        assertEquals(1,queue.size());
        
        queue.deQueue();
        assertTrue(queue.isEmpty());
        
        
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        assertEquals(5,queue.size());
    }
    
    
    @Test
    public void LinkedListQueueTest()
    {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer> ();
        
        queue.enQueue(3);   
        queue.enQueue(5);
        assertEquals(2,queue.size());
        
        assertEquals(new Integer(3),queue.deQueue());
        assertEquals(1,queue.size());
        
        queue.deQueue();
        assertTrue(queue.isEmpty());
        
        
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        assertEquals(5,queue.size());
    }
    
    
    
    
}

/**
 * 앞,뒤를 가리키는 포인터가 -1이면 큐가 비워 있는 것이다.
 * 
 * 고정 사이즈 
 * 이 클래스에서만 관련된 예외를 발생시킨다.
 *
 */
class ArrayQueue
{
    private int front = -1;
    private int rear = -1;
    private int capacity;
    
    private int[] queue;
    
    public ArrayQueue()
    {
        this(3);
    }
    
    public ArrayQueue(int size)
    {
        queue = new int[size];
        capacity = size;
    }
    
    
    public void enQueue(int data)
    {
        if(isFull())
        {
            return;
        }
       
        rear = (rear + 1)%capacity;
        queue[rear] = data;
        
        if(front == -1) front = rear;
    }
   
    
    public int deQueue()
    {
        if(isEmpty()) return -1;
        
        int data = queue[front];
        if(front == rear)
        {
            front = -1;
            rear = - 1;
        }
        else
        {
            front = (front + 1)%capacity;
        }
        
        return data;
    }
    
    
    public boolean isEmpty()
    {
        return (front == -1);
    }
    
    
    public boolean isFull()
    {
        return ((rear + 1)%capacity == front);
    }
    
    public int size()
    {
        if(front == -1) return 0;
        
        if(rear >= front){
            return (rear - front + 1);
        }else{
            
            return (capacity - front + rear + 1);
        }
        
        //return (rear - front + 1 + capacity)%capacity;    
        //return (rear - front + 1);
    }
}


class DynArrayQueue
{
    private int front = -1;
    private int rear = -1;
    private int capacity;
    
    private int[] queue;
    
    public DynArrayQueue()
    {
        this(3);
    }
    
    public DynArrayQueue(int size)
    {
        queue = new int[size];
        capacity = size;
    }
    
    
    public void enQueue(int data)
    {
        if(isFull()) expand();
        
        rear = (rear + 1)%capacity;
        queue[rear] = data;
        
        if(front == -1) front = rear;
        
        
        System.out.println("enQueue() front : " + front +", rear :" + rear);
    }
   
    
    public int deQueue()
    {
        if(isEmpty()) return -1;
        
        int data = queue[front];
        if(front == rear)
        {
            front = -1;
            rear = - 1;
        }
        else
        {
            front = (front + 1)%capacity;
        }
        
        System.out.println("deQueue() front : " + front +", rear :" + rear);
        
        return data;
    }
    
    
    public boolean isEmpty()
    {
        System.out.println("isEmpty() front : " + front +", rear :" + rear);
        return (front == -1);
    }
    
    
    public boolean isFull()
    {
        return ((rear + 1)%capacity == front);
    }
    
    
    public int size()
    {
        if(front == -1) return 0;
        
        if(rear >= front){
            return (rear - front + 1);
        }else{
            
            return (capacity - front + rear + 1);
        }
    }
    
    private void expand()
    {
        capacity *=2;
        int[] newQueue = new int[capacity];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        queue = newQueue;
    }
}



class LinkedListQueue<T>
{
    private Node front;
    private Node rear;
    

    public void enQueue(T data)
    {
        final Node node = new Node(data);
        
        if(rear != null)
        {
            rear.next = node;
        }
        rear = node;
        
        if(front == null) front = rear;
    }
    
    
    public T deQueue()
    {
        T data = null;
        if(isEmpty())
        {
            return null;
        }
        
        data = front.getData();
        front = front.next;
        
        return data;
    }
    
    
    public boolean isEmpty()
    {
        return (front == null);   
    }
    
    public int size()
    {
        int count = 0;
        Node curr = front;
        while(curr !=null)
        {
            curr = curr.next;
            count++;
        }
        return count;
    }
    
    class Node
    {
        private T data;
        private Node next;
        
        public Node(T data)
        {
            this.data = data;
        }
        
        public T getData()
        {
            return data;
        }
    }
}


