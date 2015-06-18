package com.kyumdroid.study.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public final class Util
{
    @Test
    public void isBlankCharTest()
    {
        assertTrue(isBlankChar("  "));
        assertFalse(isBlankChar("sdada"));
    }
    
    /**
     * trim 메서드는 공백문자를 확인하기 위해 내부에 인스턴스를 생성하고, 오로지 공백 문자('')만을 비교하며
     * 공백으로 간주될 수 있는 다른 특수문자는 확인하지 않는다. 
     * Character 클래스의 isWhitespace 메서드로 해결할 수 있다.
     */
    public static boolean isBlankChar(final String data){
        boolean result = false;
        
        if(data == null || data.length() == 0){
            result = true; 
        }else{
            int length = data.length();
            for(int i = 0; i < length; i++)
            {
                if(Character.isWhitespace(data.charAt(i))){
                    result = true;
                    break;        
                }
                    
            }
        }
        return result;
    }
    
    

}
