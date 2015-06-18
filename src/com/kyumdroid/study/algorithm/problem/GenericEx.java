package com.kyumdroid.study.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (문제) : Integer 리스트의 각 원소에 1을 더한 사본을 만드는 메소드를 구현하라.
 * 
 *
 */
public class GenericEx
{

    public static void main(String[] args)
    {
        OperationManager<Integer> manager = new OperationManager<>();
        System.out.println(manager.update((Arrays.asList(new Integer[]{2,4,6,8,11})), new AddOperation()));
    }
    
    
    public static List<Integer> doWork(final List<Integer> list)
    {
        final List<Integer> resultList = new ArrayList<>(list.size());
        for(Integer num : list)
        {
            resultList.add(num + 1);
        }
        
        return resultList;
    }

}


class OperationManager<T> 
{
    public List<T> update(final List<T> list, final IOperation<T> op)
    {
        final ArrayList<T> resultList = new ArrayList<T>(list.size());
        for(final T num : list)
        {
            resultList.add(op.operation(num));
        }
        return resultList;
    }
}

class AddOperation implements IOperation<Integer>
{
    public Integer operation(Integer data)
    {
        return data + 1;
    }
}

interface IOperation<T>
{
    T operation(T data);
}
