package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void hello1(){
        System.out.println("test 1 ");
    }
    @Test
    public void hello2(){
        System.out.println("test 2 ");
    }

    @Test
    public void hello3(){
        System.out.println("test 3 ");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }




}
