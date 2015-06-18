package com.kyumdroid.study.pattern;

import java.util.LinkedList;

/**
 *  인터페이스 구현 부분을 클라이언트에게 직접 지정할 수 있게 한 템플릿 메서드 패턴도 있다.
 *  이렇게 되면 해당 클래스 수정 없이 클라이언트가 동작을 정의할 수 있게 된다. 
 * 
 *
 */
public class TemplateMethodPatternEx2
{
    public static void main(String[] args)
    {
        /** Client */
        Search basicSearch = new Search();
        basicSearch.doWork();
        
        
        /** Client2 */
        Search custromSearch = basicSearch.filter(new SearchPredicate()
        {
            @Override
            public boolean isValid(String value)
            {
                return (value != null)&&(!value.isEmpty()) ;
            }
        });
    }
}

class Search
{
    private final LinkedList<String> data;
    
    public Search()
    {
        data = new LinkedList<String>();
    }
    
    public Search(final LinkedList<String> data)
    {
        this.data = data;
    }
    
    public void doWork()
    {
        //TODO : 
    }
    
    public Search filter(final SearchPredicate filter)
    {
        final LinkedList<String> item = new LinkedList<String>();
        for(String value : data)
        {
            if(filter.isValid(value))
            {
                item.add(value);
            }
        }
        
        return new Search(item);
    }
}

interface SearchPredicate
{
    public boolean isValid(String value);
}

