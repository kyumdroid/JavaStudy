package com.kyumdroid.study.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitLifeCycle
{
    private static int count = 0;
    
    @BeforeClass
    public static void setup()
    {
        //System.out.println("@BeforeClass setup()");
        
        assertEquals(0,count);
        count++;
    }
    
    public JUnitLifeCycle()
    {
        //System.out.println("JUnitLifeCycle()");
        
        assertTrue(Arrays.asList(1,5).contains(count));
        count++;
    }
     
    @Before
    public void beforeTest()
    {
        //System.out.println("@Before beforeTest()");
        
        assertTrue(Arrays.asList(2,6).contains(count));
        count++;
    }
    
    @Test
    public void firstTest()
    {
        //System.out.println("@Test firstTest()");
        
        assertTrue(Arrays.asList(3,7).contains(count));
        count++;
    }
    
    @Test
    public void secondTest()
    {
        //System.out.println("@Test secondTest()");
        
        assertTrue(Arrays.asList(3,7).contains(count));
        count++;
    }
    
    @After
    public void afterTest()
    {
        //System.out.println("@After afterTest()");
        
        assertTrue(Arrays.asList(4,8).contains(count));
        count++;
    }
    
    
    @AfterClass
    public static void finish()
    {
        //System.out.println("@AfterClass finish()");
        
        assertEquals(9,count);
    }
}
