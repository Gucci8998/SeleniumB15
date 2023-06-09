package com.test.etsy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseEtsy {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("url_etsy"));
    }

    @AfterTest
    public void tearDown(){

        BrowserUtils.getScreenShot(driver,"etsy");
       // driver.quit();
    }

}
