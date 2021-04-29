package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationsOneTest {
    @BeforeClass
    public static void beforeClassAnnotation() {
        System.out.println("Before Class Annotation");
    }
    
    @Before
    public void beforeAnnotation() {
        System.out.println("Before Annotation");
    }
    
    @After
    public void afterAnnotation() {
        System.out.println("After Annotation");
    }
    
    @AfterClass
    public static void afterClassAnnotation() {
        System.out.println("After Class Annotation");
    }
    
    @Test
    public void testOne() {
        System.out.println("Test 01");
    }
    
    @Test
    public void testTwo() {
        System.out.println("Test 02");
    }
    
    @Test
    public void testThree() {
        System.out.println("Test 03");
    }
}
