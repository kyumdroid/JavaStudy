package com.kyumdroid.study.pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *  설명 : 오직 하나의 인스턴스만 생성하는 패턴이다. 
 *         인스턴스가 생성되었는지 확인하고, 생성되지 않았다면 동기화를 하고 인스턴스를 생성한다. 
 *         volatile 키워드를 사용하면 원자성을 보장해서, 멀티스레드 상황에서도 인스턴스 초기화 과정이 바르게 진행된다. 
 *
 *         Enum을 이용해서 싱글톤 클래스를 만들 수도 잇다. 이럴 경우 Serialize를 자동으로 구현해줘서
 *         객체 Serialize가 가능하다. 또한 Enum 타입은 만들기도 쉬울 뿐더러 JVM이 하나의 인스턴스만 생성하는 것을 보장해준다.
 *         
 */
public class SingletonPatternEx
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //방법 1.
        Singleton singleton = Singleton.getInstance(); 
        singleton.doWork();
        
        Singleton singleton2 = Singleton.getInstance(); 
        singleton2.doWork();
        
        //방법 2.
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("test.txt")));
        oos.writeObject(singletonEnum);
        oos.close();
        
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("test.txt")));
//        SingletonEnum readObj = (SingletonEnum)ois.readObject();
//        readObj.doWok();
//        ois.close();
    }
}

class Singleton
{
    private volatile static Singleton mInstance;
    
    private Singleton(){};
    
    public static Singleton getInstance()
    {
//        if(mInstance == null)  
//        {
            synchronized(Singleton.class)
            {
                if(mInstance == null)
                {
                    mInstance = new Singleton();
                }
            }
//        }
        return mInstance;
    }
    
    public void doWork()
    {
        //TODO : 
    }
}

enum SingletonEnum
{
    INSTANCE;
    
    public void doWok()
    {
      //TODO : 
    }
}