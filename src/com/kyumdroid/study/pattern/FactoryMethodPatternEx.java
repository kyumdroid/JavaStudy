package com.kyumdroid.study.pattern;

/**
 *   객체를 생성하기 위한 인터페이스를 정의하는데, 어떤 클래스를 만들지는 서브클래스에서 결정하게 만든다.
 *   팩토리 메소드 패턴을 이용하면 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 것이다.
 *   - 헤드퍼스트
 *   
 *   객체 인스턴스를 직접 만들면 구상 클래스에 의존해야 한다.
 *   구상 클래스에 의존하도록 만들지 말고, 추상화된 것에 의존하도록 만들어라.  
 * 
 *
 */
public class FactoryMethodPatternEx
{
    
    
    public static void main(String[] args)
    {
               
    }

}

abstract class Creator
{
    protected abstract Product create();
    
    public Product order()
    {
        Product product = create();
        //TODO : 
        
        return  product;
    }
}

abstract class Product
{
    public void prepare()
    {
        
    }
    
    public void operation1()
    {
        
    }
    
    public void operation2()
    {
        
    }
}


class ConcreateCreator extends Creator
{
    @Override
    public Product create()
    {
        Product product = new ConcreateProduct();
        //TODO :
        
        return product;
    }
    
}

class ConcreateProduct extends Product
{
    @Override
    public void operation1()
    {
        
    }
}



