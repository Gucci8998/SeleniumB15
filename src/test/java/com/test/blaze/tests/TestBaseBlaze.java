package com.test.blaze.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class TestBaseBlaze {

    public WebDriver driver;


//    @BeforeSuite
//    public void clearTheCaches(){
//        driver= DriverHelper.getDriver();
//        driver.manage().deleteAllCookies();
//
//    }
    @BeforeMethod
    public void setup(){

        driver= DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){

        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blazepicture");
        }
        driver.quit();
    }
}
