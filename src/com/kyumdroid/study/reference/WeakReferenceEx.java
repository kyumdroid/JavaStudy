package com.kyumdroid.study.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceEx
{
    public static void main(String[] args)
    {
        DataManager manager = new DataManager();
        manager.setData(new Data());
        
        System.out.println(manager.getData());
        System.out.println(manager.getData());
        System.out.println(manager.getData());
        System.out.println(manager.getData());
        
        System.gc();
        
        System.out.println(manager.getData());
    }
}


class DataManager
{
    private WeakReference<Data> ref;
    
    
    public void setData(final Data data)
    {
        ref = new WeakReference<Data>(data);
    }
    
    public Data getData()
    {
        if(ref != null) return ref.get();
        
        return null;
    }
}

class Data
{
}



//class DataManager
//{
//    private WeakReference<Info> ref;
//    
//    
//    public void setData(final Info info)
//    {
//        ref = new WeakReference<Info>(info);
//    }
//    
//    public Info getData(final Info info)
//    {
//        Info data = null;
//        
//        if(ref != null) data = ref.get();
//        
//        System.out.println("data : " + data);
//        if(data == null)
//        {
//            data = info;  //편의상..
//            ref = new WeakReference<Info>(data);
//        }
//        return data;
//    }
//}
//
//class Info
//{
//    
//}



















