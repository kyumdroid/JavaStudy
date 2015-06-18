package com.kyumdroid.study.etc;

/**
 *  객체를 비교할 때 equals(Object object) 메소드를 많이 사용한다.
 *  JVM에서 실행되는 모든 클래스는 java.lang.Object를 상속하고, equals() 메소드는 Object 클래스에 존재함으로
 *  오버라이딩해서 재정의 할 수 있다. 
 *  
 *  String 객체의 경우에는 오버라이딩 하기 때문에 다음과 같은 결과를 낳는다.
 * 
 * 
 *
 */
public class HashCodeEx
{
    public static void main(String[] args)
    {
//        HashCodeEx.testString();
        
        HashCodeEx.testObject();
    }
    
    
    public static void testString()
    {
        String a = new String("item");
        String b = new String("item");
        
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a.hashCode() : " + a.hashCode());
        System.out.println("b.hashCode() : " + b.hashCode());
    }
    
    public static void testObject()
    {
        Person person1 = new Person("900305");
        Person person2 = new Person("900305");
        
        
        System.out.println("person1.equals(person2) : " + person1.equals(person2));
        System.out.println("person1 == person2 : " + (person1 == person2));
        System.out.println("person1.hashCode() : " + person1.hashCode());
        System.out.println("person2.hashCode() : " + person2.hashCode());
    }
}




class Person
{
    String idNumber;
    
    public Person(String idNumber)
    {
        this.idNumber = idNumber;
    }

    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Person)
        {
            return idNumber.equals(((Person)o).idNumber);
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return idNumber.hashCode();
    }
}
