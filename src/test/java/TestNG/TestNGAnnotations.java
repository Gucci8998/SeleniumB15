package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test annotation");
    }

    @BeforeClass //it runs before every class and people use it to launch their browser
    public void beforeClass(){
        System.out.println("i am before class annotation");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("I am before Method annotation");
    }
    @Test
    public void test(){
        System.out.println("I am test annotation");
    }

    @Test
    public void test2(){
        System.out.println("I am second test annotation");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after test annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite annotation");
    }
}
