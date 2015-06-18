package com.kyumdroid.study.algorithm;


public class TestEx
{
    public static void main(String[] args)
    {
        TArrayQueue Queue = new TArrayQueue();
        Queue.enQueue(1);
        Queue.enQueue(2);
        Queue.enQueue(3);

        System.out.println(Queue.size());
        
        Queue.deQueue();
        Queue.deQueue();

        System.out.println(Queue.size());
        
        Queue.enQueue(2);
        Queue.enQueue(3);

        System.out.println(Queue.size());
        
        
    }
}

class TLinkedListQueue<T>{

    private Node front;
    private Node rear;
    
    public void enQueue(T data){
        final Node node = new Node(data);
        
        if(rear != null){
            rear.next = node;
        }
        rear = node;
        
        if(front == null) front = rear;
    }
    
    public T deQueue(){
//        if(isEmpty()) return null;
        T data = null;
        data = front.getData();
        front = front.next;
        
        return data;
    }
    
    class Node{
        T data;
        Node next;
        
        public Node(T data){
            this.data = data;
        }
        
        public T getData(){
            return data;
        }
    }
}


class TArrayQueue{
    private int front = -1;
    private int rear = -1;
    private int capacity;
    
    private int[] queue;
    
    public TArrayQueue(){
        this(3);     
    }
    
    public TArrayQueue(int size){
        queue = new int[size];
        capacity = size;
    }
    
    public void enQueue(int data){
        if(isFull()) return;
        
        rear = (rear + 1)%capacity;
        queue[rear] = data;
        
        if(front == -1) front = rear;
    }
    
    public int deQueue(){
        if(isEmpty()) return -1;
        
        int data = queue[front];
        if(front == rear){
            front = -1;
            rear = -1;
        }else{
            front = (front + 1)%capacity;
        }
        
        return data;
    }
    
    private boolean isEmpty(){
        return (front == -1);
    }
    
    private boolean isFull(){
        return ((rear + 1)%capacity == front);
    }
    
    public int size(){
        if(front == -1) return 0;
        
        System.out.println("capacity : " + capacity + ",  front : " + front + ", rear : " + rear);
        
        if(rear >= front){
            return (rear - front + 1);
        }else{
            
            return (capacity - front + rear + 1);
        }
        
//        if(front == -1) return 0;
//        
//        return Math.abs(rear - front) + 1;
    }
}

