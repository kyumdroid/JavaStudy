package com.kyumdroid.study.etc;

public class StringEx
{
    public static void main(String[] args)
    {
        
        findStringTest();
        
        
    }
    
    /**
     * indexOf() 메서드는 불특정 위치의 문자열을 찾을 때
     * startsWith() 메서드는 접두사로 특정 문자가 시작될 때
     * charAt() 메서드는 첫 문자를 찾을 때
     */
    public static void findStringTest()
    {
        String strIndexOf = "12198ANDROID0801";
        String strStartsWith = "ANDROID20943";
        String strCharAt = "ANDROID1028";
        
        System.out.println("'12198ANDROID0801'에서 ANDROID 문자열은 " + strIndexOf.indexOf("ANDROID") + "번째 존재한다.");
         
        System.out.println("'ANDROID20943'에서 ANDROID문자가 처음에 존재 하나?? " + strStartsWith.startsWith("ANDROID"));

        System.out.println("'ANDROID1028'에서 첫 문자는 " + strCharAt.charAt(0));
    }
    
    

}
