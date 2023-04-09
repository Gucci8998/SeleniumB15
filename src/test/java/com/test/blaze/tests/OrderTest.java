package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze{

    @DataProvider(name = "customerInfo")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Turkey","Ankara","213421","12","2025"},
                {"John","USA","Chicago","12345","5","2023"},
                {"Phuong Pak","Vietnam","SiyLong","123432345","3","2024"}
        };
    }

@Test(dataProvider = "customerInfo")
    public void validateOrderFunctionality(String name, String country,String city,String creditCard,String month, String year) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseMacBook("MacBook Pro");
        MacBookPage macBookPage = new MacBookPage(driver);
        macBookPage.clickaddToCart(driver,"Product added");
        mainPage.presscartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateInfo("MacBook Pro","1100");
        cartPage.clickPlaceOrder();
        OrderPage orderPage = new OrderPage(driver);
      //  orderPage.placeOrderInfo("Gigi","USA","Chicago","234567890" ,"March","2023");
         orderPage.placeOrderInfo(name,country,city,creditCard,month,year);
        orderPage.validatePurchaseSuccessfullydone("Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/index.html");
    }
}
