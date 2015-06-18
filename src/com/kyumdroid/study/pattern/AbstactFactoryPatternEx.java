package com.kyumdroid.study.pattern;

/**
 * @author kyum
 *  클라이언트 입장에서 해당 팩토리만 알고 추상 형식만 알면 알아서 
 *  interface를 구현한  서브 클래스에서 객체를 만들어서 반환해준다.
 *  각 객체를 생성하는 부분을 캡슐화 한 것이다. 
 *  
 *  추상 인터페이스를 통해 일련의 제품들을 공급받을 수 있다. 구상 클래스를 지정하지 않아도 된다.
 *  실제로 어떤 제품이 생산되는지 알 필요가 없다. 따라서 클라이언트와 팩토리에서 생산되는 제품을 분리 시킬 수 있따. - 헤드 퍼스트
 * 
 *  추상 팩토리 패턴에서 제품을 생산하기 위한 메소드를 구현하는 데 있어서 팩토리 메소드를 사용하는 것은 자연스러운 것이다.
 *  
 *  추상 팩토리 패턴은 객체를 만들 때 객체 구성(composition)을 통해 만들고, 팩토리 메소드 패턴은 클래스를 상속하고 메소드 오버라이드를 통해 만든다.
 *  
 */
public class AbstactFactoryPatternEx
{
    public static void main(String[] args)
    {
        IFactory factory = new BookFactory();
        IProduct product = factory.create();
        
    }
}


interface IFactory
{
    public IProduct create();
}

interface IProduct
{
    
}

class BookFactory implements IFactory
{
    public IProduct create()
    {
        return new AProduct();
    }
}

class ToyFactory implements IFactory
{
    public IProduct create()
    {
        return new BProduct();
    }
}

class AProduct implements IProduct
{
    
}

class BProduct implements IProduct
{
    
}

