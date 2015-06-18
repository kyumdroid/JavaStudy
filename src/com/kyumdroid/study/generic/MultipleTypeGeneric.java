package com.kyumdroid.study.generic;

public class MultipleTypeGeneric<K,V> implements Item<K,V>
{
    private K key;
    private V value;
        
    public MultipleTypeGeneric(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey()
    {
        return key;
    }

    @Override
    public V getValue()
    {
        return value;
    }
    
    public static void main(String[] args)
    {
        Item<String, Integer> item1 = new MultipleTypeGeneric<String,Integer>("item",4);
        Item<String, Boolean> item2 = new MultipleTypeGeneric<String,Boolean>("goods",true);
    }
}

interface Item<K,V>
{
    public K getKey();
    public V getValue();
}