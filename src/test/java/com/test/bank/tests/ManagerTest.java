package com.test.bank.tests;

import com.test.bank.pages.LoginPage;
import com.test.bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class ManagerTest {
WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("url"));
    }

    @Test
    public void validateBankPage(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressLoginButton();
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addCustomer(ConfigReader.readProperty("name"),ConfigReader.readProperty("lastName"),ConfigReader.readProperty("postcode"));
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
        alert.accept();
        managerPage.OpenAccount();
       managerPage.selectName("Gucci ibr");
      managerPage.selectCurrencyandProcess();
      Alert alert2 = driver.switchTo().alert();
      Assert.assertTrue(alert2.getText().contains("Account created successfully"));
      alert2.accept();
      managerPage.openCustomerButton("Gucci","Gucci","ibr","34613");








    }
//    @Test
//    public void validateBankPage2() {
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.pressLoginButton();
//        ManagerPage managerPage = new ManagerPage(driver);
//        managerPage.addCustomer("Gucci", "Ibr", "34613");
//        Alert alert = driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
//        alert.accept();
//        managerPage.OpenAccount();
//        managerPage.selectName("Gucci Ibr");
//        managerPage.selectCurrencyandProcess();
//        Alert alert2 = driver.switchTo().alert();
//        Assert.assertTrue(alert2.getText().contains("Account created successfully"));
//        alert2.accept();
//
//
//
//    }

//    @Test
//    public void validateBankPage3() {
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.pressLoginButton();
//        ManagerPage managerPage = new ManagerPage(driver);
//        managerPage.addCustomer("Gucci", "Ibr", "34613");
//        Alert alert = driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
//        alert.accept();
//        managerPage.OpenAccount();
//        managerPage.selectName("Gucci Ibr");
//        managerPage.selectCurrencyandProcess();
//        Alert alert2 = driver.switchTo().alert();
//        Assert.assertTrue(alert2.getText().contains("Account created successfully"));
//        alert2.accept();
//        managerPage.openCustomerButton("Gucci", "Gucci", "Ibr", "34613");
//    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    }
