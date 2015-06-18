package com.kyumdroid.study.algorithm;

public class TreeEx
{
    
    
    public static void main(String[] args)
    {

    }

}


class Tree<T>
{
    /** 전위 탐색 */
    public void preTree(Node root)
    {
        if(root == null) return;
        
        System.out.println(root.getData());  // 현재 노드 작업 수행
        preTree(root.getLeft());
        preTree(root.getRight());
    }
    
    /** 중위 탐색 */
    public void midTree(Node root)
    {
        if(root == null) return;
        
        midTree(root.getLeft());
        System.out.println(root.getData());  // 현재 노드 작업 수행
        midTree(root.getRight());
    }
    
    /** 후위 탐색 */
    public void rearTree(Node root)
    {
        if(root == null) return;
        
        midTree(root.getLeft());
        midTree(root.getRight());
        System.out.println(root.getData());  // 현재 노드 작업 수행
    }
    
    /** 레벨 순서 탐색*/
    public void level(Node root)
    {
        if(root == null) return;
        
        Node temp;
        LinkedListQueue<Node> queue = new LinkedListQueue<Node>();
        
        queue.enQueue(root);
        while(!queue.isEmpty())
        {
            temp = queue.deQueue();
            System.out.println(temp.getData());  // 현재 노드 작업 수행
            
            if(temp.getLeft() != null) queue.enQueue(temp.getLeft());
            
            if(temp.getRight() != null) queue.enQueue(temp.getRight());
        }
    }
    
    
    class Node
    {
        T data;
        Node left;
        Node right;
        
        public Node(T data)
        {
            this.data = data;
        }
        
        public T getData()
        {
            return data;
        }
        
        public Node getLeft()
        {
            return left;
        }
        
        public Node getRight()
        {
            return right;
        }
    }
}
