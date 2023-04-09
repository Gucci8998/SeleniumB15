package com.test.sauce.tests;

import com.test.sauce.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceLoginTest  extends TestBaseSauce{

//    @DataProvider(name = "negativeLogin")
//    public Object[][] getUserInfo(){
//        return new Object[][]{
//                {"problem_user","","Epic sadface: Password is required"},
//                {"","secret_sauce","Epic sadface: Username is required"},
//                {"wrong_username","wrong_password","Epic sadface: Username and password do not match any user in this service"}
//        };
//    }
    @Test
    public void validatePositiveLogin(){
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("OA_username"),ConfigReader.readProperty("OA_password"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test (dataProvider = "negativeLogin",dataProviderClass = AllData.class)
    public void validateNegativeLogin(String username, String password, String message){
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginNegative(username, password, message);

    }
}
