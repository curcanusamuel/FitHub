package com.example.spring.Tests;

import com.example.spring.Cezar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CezarTests {
    private Cezar cezar=new Cezar();
    @Test
    public void testEasy1(){
        assertEquals("bcd", cezar.computePassword("abc","Easy"));
    }
    @Test
    public void testEasy2(){
        assertEquals("bob", cezar.computePassword("ana","Easy"));
    }
    @Test
    public void testMedium1(){
        assertEquals("efg", cezar.computePassword("abc","Medium"));
    }
    @Test
    public void testMedium2(){
        assertEquals("neze", cezar.computePassword("java","Medium"));
    }
    @Test
    public void testMedium3(){
        assertEquals("bcd", cezar.computePassword("xyz","Medium"));
    }


}
