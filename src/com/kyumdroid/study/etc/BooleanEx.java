package com.kyumdroid.study.etc;

import java.util.ArrayList;
import java.util.List;

/**
 * Boolean 객체 생성 시 static 필드로 정의한 Boolean.TURE, Boolean.FALSE 로 해서 불필요한 객체 생성을 피한다.
 * 
 * 
 *
 */
public class BooleanEx
{
    public static void main(String[] args)
    {
//        Boolean b = new Boolean(true);
        Boolean b = Boolean.TRUE;
        
        
        final List<Boolean> list = new ArrayList<Boolean>();
        list.add(Boolean.TRUE);
        list.add(Boolean.FALSE);

    }

}
