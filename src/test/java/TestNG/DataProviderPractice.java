package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "couples")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Ayse"},
                {"Mr.M", "Mrs.M"},
                {"Ivana","Darko"},
                {"Gulmira","Valid"},
                {"Mr.B","Mrs Juliana"}
        };
    }
    @Test(dataProvider = "couples")
    public void test1(String firstCouple, String secondCouple){
        System.out.println(firstCouple + secondCouple);
    }

//    @Test
//    public void test2(){
//        System.out.println("Mr. M" + "Mrs. M");
//    }
//
//    @Test
//    public void test3(){
//        System.out.println("Ivana" + "Darko");
//    }
//
//    @Test
//    public void test4(){
//        System.out.println("Gulmira" + "Valid");
//    }
//
//    @Test
//    public void test5(){
//        System.out.println("Mr. B" + "Ms. Ju");
//
//    }
}
