package com.kyumdroid.study.etc;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * 
 * 
 * 
 * 
 *
 */
public class PropertiesEx
{
    @Test
    public void test()
    {
        assertEquals("fail read 'ip' from config file","127.0.0.1",getValue("ip"));
    }

    
    private static String getValue(String key)
    {
        Properties properties = null;
        String value = null;
        
        /** 방법 3가지 */
//          InputStream is = ClassLoader.getResourceAsStream("com/kyumdroid/study/etc/config.properties");
//          InputStream is = (PropertiesEx.class).getResourceAsStream("/com/kyumdroid/study/etc/config.properties");
//          InputStream is = new FileInputStream("d:\\config.properties");
        
        
       try(InputStream is =  ClassLoader.getSystemResourceAsStream("com/kyumdroid/study/etc/config.properties");){
            properties = new Properties();
            properties.load(is);
            value = properties.getProperty(key);
        }catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }
}
