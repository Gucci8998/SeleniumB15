package softAssertPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIntro {
    public int getSum(int num1,int num2){
        return num1+num2;
    }
    @Test
    public void test(){
        Assert.assertEquals(getSum(1,5),6);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,7),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(5,9),14);
        System.out.println("test3");
    }
    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getSum(1,5),6);
        System.out.println("test1");
        softAssert.assertEquals(getSum(3,7),8);
        System.out.println("test2");
        softAssert.assertEquals(getSum(5,9),14);
        System.out.println("test3");
        softAssert.assertAll();
    }
}
