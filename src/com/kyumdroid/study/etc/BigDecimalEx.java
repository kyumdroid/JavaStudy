package com.kyumdroid.study.etc;

import java.math.BigDecimal;


/**
 * BigDecimal은 float이나 double 보다 리소스를 많이 점유하지만 정확한 소수점 계산을 할 수 있다.
 * 
 * BigDecimal 객체 비교싱 equals 메소드보다는 compareTo 메소드가 더 명확하다.
 * 
 * 
 * 
 */
public class BigDecimalEx
{
    public static void main(String[] args)
    {
        float a = 1.5f;
        float b = 2.4f;
        
        BigDecimal c = new BigDecimal("1.5");
        BigDecimal d = BigDecimal.valueOf(2.4);
        BigDecimal e = BigDecimal.valueOf(2.400);
        
        System.out.println("a*b : "  + (a*b));
        System.out.println("c*d : "  + c.multiply(d));
        System.out.println("d.compareTo(e) : "  + (d.compareTo(e) == 0));
        System.out.println("d.equals(e) : "  + d.equals(e));
        
        
        int num = 255;
        //10진수, 16진수, 8진수 표현
        
        System.out.println(String.format("10진수 : %d \t|\t 8진수 : %o \t|\t 16진수 : %x", num,num,num));
        
        
       
        
        
    }
}


