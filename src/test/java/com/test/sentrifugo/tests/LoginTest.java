package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public void validateSuccessfulLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM02","sentrifugo");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));


    }
@Test
    public void validateNegativeLogin1(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://demo.sentrifugo.com/index.php/");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("ahmet","sentrifugo");

    Assert.assertEquals(loginPage.validateMessage(),"The username or password you entered is incorrect.");
    Assert.assertEquals(loginPage.validateColorofTheMessage(),"rgba(255, 0, 0, 1)");
}
}
