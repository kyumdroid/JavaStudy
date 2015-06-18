package com.kyumdroid.study.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class JUnitAssertEx
{
    private static  int number = 5; 
    
    @Test
    public void testAssertEquals()
    {
        assertEquals("Not Equals", 5, number);
    }
    
    @Test
    public void testAssertTrue()
    {
        assertTrue("Not True", Arrays.asList(3,5).contains(number));
    }
    
    @Test
    public void testAsserFalse()
    {
        assertFalse("Not False", Arrays.asList(13,17).contains(number));
    }
    
    
    @Test
    public void doTest()
    {
        //TODO : 
    }
    
    @Test
    public void testAssertNotNull()
    {
        JUnitAssertEx test = new JUnitAssertEx();
        assertNotNull("Null", test);
    }
    
    @Test
    public void testAssertArrayEquals()
    {
        assertArrayEquals("Not Array Equals", new Integer[]{1,4,9},new Integer[]{1,4,9});;
    }
}
