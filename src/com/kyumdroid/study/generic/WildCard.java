package com.kyumdroid.study.generic;

import java.util.Arrays;
import java.util.List;

/** 
 *  물음표(?)는 와일드 카드라고 불린다. 와일드 카드는 어떤 타입이든지 나타낼 수 있다.
 * 
 * */
public class WildCard
{

    /** 여기서 ?는 Number를 상속하는 자식 클래스여야 한다.*/
    public static double sumOfList(List<? extends Number> list)
    {
        double sum = 0.0;
        
        for(Number n : list)
        {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    /** ?는 Integer의 부모 클래스여야 한다.*/
    public static void addNumbers(List<? super Integer> list)
    {
        for(int i = 0; i < 10; i++)
        {
            list.add(i);
        }
    }
    
    public static void main(String[] args)
    {
        List<Integer> li = Arrays.asList(1,2,3);
        System.out.println("sum = " + sumOfList(li));
    }

}
