package com.kyumdroid.study.pattern;

import java.util.Arrays;
import java.util.List;

/**
 *  설명 : 알고리즘을 각각 캡슐화하여 클라이언트에서 원하는 알고리즘을 쉽게 교환 가능하도록 만든 패턴이다. 
 *  
 *            
 *  
 *  특징 : 캡슐화 방법은 인터페이스를 만들고 구체적인 것은 아래에서 구현한다. 
 *        또 다른 알고리즘을 구현해야 한다면 인터페이스를 구현하면 되고, 클라이언트는 
 *        동일한 인터페이스를 인스턴스로 가지고 있기 때문에 원하는 데이터 형식으로 생성만 하면 된다. 
 *
 *        스프링 프레임워크는 객체나 의존성을 생성할 때 XML 파일을 사용하며, 웹 애플리켕션을 실행 할 때 이 파일을 먼저 읽어온다.
 *        사용자는 XML파일의 내용을 변경하면 다시 컴파일할 필요 없이 다른 구현 방법을 이용할 수 있다.
 *
 */
public class StrategyPatternEx
{

    public static void main(String[] args)
    {
        List<Integer> numList =  Arrays.asList(new Integer[]{6,2,17,3,4});
        List<String> strList =  Arrays.asList(new String[]{"book","item","data"});
        
        final Client<Integer> client = new Client<>( new SelectionSort<Integer>());
        client.work(numList);
        
        final Client<String> client2 = new Client<>( new InsertSort<String>());
        client2.work(strList);
        
    }
}

class Client<E> 
{
    private final ISort<E> sortManager;
    
    public Client(ISort<E> sortManager)
    {
        this.sortManager = sortManager;
    }
    
    public void work(List<E> element)
    {
        sortManager.sort(element);
    }
}


interface ISort<E> 
{
    public List<E> sort(List<E> element);    
}

class SelectionSort<E> implements ISort<E> 
{
    @Override
    public List<E> sort(final List<E> element)
    {
        //TODO : do selection sort
        
        return null;
    }
}

class InsertSort<E> implements ISort<E> 
{
    @Override
    public List<E> sort(final List<E> element)
    {
        //TODO : do insert sort
        
        return null;
    }
}



