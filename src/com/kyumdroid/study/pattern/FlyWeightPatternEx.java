package com.kyumdroid.study.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : 공통으로 사용되는 객체는 새로 생성하지 않고 공유함으로써 효율적으로 자원을 활용하는 패턴이다.
 *       한번 생성된 객체는 새롭게 생성하지 않고 풀에 의해 관리되어 메모리를 절약할 수 있다.
 *       
 *       어떻게 트리 구조를 구현하느냐에 따라 간단한 null 값을 참조하거나 Null 객체를 사용하고 싶을 것이다.
 *       이런 경우 각 리프 노드가 자신만의 Null 객체를 소유할 것이라고 생각할 수 있지만, 실제로는 필요할 때마다 Null 객체를 참조하는 단일 플라이웨이트 객체를 사용할 것이다.
 *       
 */

public class FlyWeightPatternEx
{
    private static final Integer[] SMALL_VALUES = new Integer[256];
    
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Integer(i);
        }
    }
    
    public static void main(String[] args)
    {
        /** 예제 1*/
        FlyWeight service = ServiceFactory.getFlyweight("service1");
        service.operation();
        
        FlyWeight service2 = ServiceFactory.getFlyweight("service2");
        service2.operation();

        FlyWeight service3 = ServiceFactory.getFlyweight("service1");
        service3.operation();
        
        /** 예제 2   자바 표준 라이브러리 Integer */
        FlyWeightPatternEx.valueOf(14);
        FlyWeightPatternEx.valueOf(156);
        
    }
    
    public static Integer valueOf(int i)
    {
        //return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
        
      
        if(i >= 128 || i < -128) 
        {
            System.out.println("새롭게 생성합니다.");
            return new Integer(i);
        }
        else
        {
            System.out.println("기존 객체를 사용합니다.");
            return SMALL_VALUES[i + 128];
        }
    }
}



interface FlyWeight
{
    public void operation();
}

class ServiceFlyWeight implements FlyWeight
{
    @Override
    public void operation()
    {
        //TODO : 서비스가 할일
    }
}


class ServiceFactory
{
    private static Map<String, FlyWeight> mFlyWeightMap = new HashMap<String,FlyWeight>();
    
    
    public static FlyWeight getFlyweight(String key)
    {
        FlyWeight fw = mFlyWeightMap.get(key);
        if(fw == null)
        {
            fw = new ServiceFlyWeight();
            mFlyWeightMap.put(key, fw);
            System.out.println("새롭게 서비스를 생성합니다.");
        }
        else
        {
            System.out.println("기존의 서비스를 사용합니다.");
        }
        return fw;
    }
}



class ServiceManager
{
    public static Service getService()
    {
        //TODO :
        return new NullService();
    }
}

interface Service
{
    public boolean isService();
}

class NullService implements Service
{
    public boolean isService()
    {
        return false;
    }
}

class RealService implements Service
{
    public boolean isService()
    {
        //TODO : 
        
        
        return true;
    }
}


