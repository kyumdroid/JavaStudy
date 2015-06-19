package com.kyumdroid.study.algorithm;


/**
 * API를 사용하지 말고 직접 연결리스트 구현하기
 * 
 * 
 * 참고 사이트 
 * https://opentutorials.org/module/1335/8857
 * http://globalbiz.tistory.com/66
 *   
 *   
 */
public class LinkedListEx
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(19);
        
        System.out.println(list);
    }

}


class LinkedList<T>
{
    private Node head;
    private Node tail;
    private int size = 0;

    
    class Node
    {
        T element;
        Node next;
        
        
        public Node(T element)
        {
            this.element = element;
            this.next = null;
        }
    }
    
    public int size()
    {
        if(head == null) return 0;
        
        int count = 0;
        Node currNode = head;
        
        while(currNode != null)
        {
            currNode = currNode.next;
        }
        return count;
    }
    
    public void add(T element)
    {
         add(size,element);
    }
    
    
    public void add(int index, T element)
    {
        if(index < 0 || index > size) return;
        
        if(index == 0)
        {
            addFirst(element);
        }
        else if(index == size)
        {
            addLast(element);
        }
        else
        {
            Node prevNode = get(index - 1);
            
            Node nextNode = prevNode.next;
            
            final Node newNode = new Node(element);
            prevNode.next = newNode;
                    
            newNode.next = nextNode;
            
            size++;
            
            if(newNode.next == null)
            {
                tail = newNode;
            }
        }
    }
    
    private void addFirst(T element)
    {
        final Node newNode = new Node(element);
        head = newNode;
        head.next = null;
        
        size++;
        tail = head;
        
    }
    
    private void addLast(T element)
    {
        if(head == null)
        {
            addFirst(element);
        }
        
        final Node newNode = new Node(element);
        tail.next = newNode;
        size++;
    }
    
    
    public Node get(int index)
    {
        Node node = head;
        for(int i = 0; i < index; i++)
        {
            node = node.next;
        }
        return node;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        
        Node curr = head;
        while(curr.next != null)
        {
            builder.append(curr.element).append(",");
            curr = curr.next;
        }
        builder.append(curr.element).append("]");
        return builder.toString();
    }

}

