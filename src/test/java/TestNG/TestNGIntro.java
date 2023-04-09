package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test (priority = 2, invocationCount = 20)//test annotation
    public void test1(){
        System.out.println("i am test 1");
    }
    @Test (priority = 1)
    public void test2(){
        System.out.println("I am test 2");
    }
    @Test (priority = 3)
    public void test3(){
        System.out.println("I am test 3");
    }
}
