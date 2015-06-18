package com.kyumdroid.study.pattern;


/**
 * Template Method Pattern(템플릿 메소드 패턴)
 * 
 * 설명 : 부모 클래스에서는 공통적인 사항(골격)을 정의하고, 
 *        세부적인 알고리즘은 자식 클래스에서 구현하거나 위임하는 패턴이다.
 *        템플릿 클래스인 부모 클래스에서는 final로 구현한 템플릿 메소드를 통해 알고리즘의 구조는 그대로 유지 가능하고
 *        특정 구현만 자식 클래스에서 정의하기도 한다. 
 *        ex) Arrays.sort(), JFrame, Applet,  
 */

public class TemplateMethodPatternEx
{
    public static void main(String[] args)
    {
        TemplateClass target = new SubClass();
        target.prepare();
    }
}

abstract class TemplateClass
{
    //템플릿 메소드.. 서브 클래스에서 알고리즘을 함부로 바꾸지 못하도록 final로 선언한다.
    final void prepare()
    {
        optionOne();
        optionTwo();
        hook();
    }
    
    abstract void optionOne();
    
    abstract void optionTwo();

    //알고리즘의 특정 부분을 서브클래스에서 선택적으로 필요할 경우에 오버라이드 해서 사용하도록 제공해준다.
    void hook(){};
}

class SubClass extends TemplateClass
{
    @Override
    void optionOne()
    {
        //TODO : 
    }

    @Override
    void optionTwo()
    {
      //TODO : 
    }

    @Override
    void hook()
    {
      //TODO : 필요에 따라 구현하기도 한다.
    }
}

