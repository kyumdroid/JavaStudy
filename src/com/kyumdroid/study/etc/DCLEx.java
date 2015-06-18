package com.kyumdroid.study.etc;

/**
 *  스레드 동기화시 스레드 동기화 영역 안/밖으로 객체 생성여부을 확인하는 DCL(Double Checked Locking)을 조심해야 한다.
 *  아래 예제에서 첫번째 스레드가 인스턴스 초기화 작업이 완전히 완료되자 않았지만, 
 *                  두번째 스레드는 동기화 영역 밖에서 null이 아님을 확인하고 인스턴스를 반환한다.
 * 
 *  아마도 간단히 인스턴스만 생성하는거면 큰 문제가 없는 듯 보이지만, 주의를 해서 동기화 영역 밖에서의 null 체크를 없애주는 것도 한 방법이다.
 *
 */
public class DCLEx
{
    public static void main(String[] args)
    {
        Thread th1 = new Thread(){
           @Override
           public void run()
           {
               SingletonSample.getInstance().doWork();
           }
        };
        
        Thread th2 = new Thread(){
            @Override
            public void run()
            {
                SingletonSample.getInstance().doWork();
            }
         };
         
         th1.start();
         th2.start();
         
    }
}


class SingletonSample
{
    private volatile static SingletonSample mInstance;
    
    private String mMsg = "초기화 필요";
    
    private SingletonSample(){};
    
    public static SingletonSample getInstance()
    {
        if(mInstance == null)  
        {
            synchronized(SingletonSample.class)
            {
                if(mInstance == null)
                {
                    mInstance = new SingletonSample();
                    System.out.println("인스턴스 생성 -> mInstance : " + mInstance);
                    mInstance.mMsg = "초기화 완료";
                }
            }
        }
        return mInstance;
    }
    
    public void doWork()
    {
        //TODO : 
        System.out.println(mMsg);
    }
}