package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class macBookTest extends TestBaseBlaze {
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
    @Parameters({"laptopBrand","laptopPrice","laptopDesc","message"})

    @Test
    public void validateMacBookPage(String laptopBrand, String laptopPrice,String laptopDesc,String message) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseMacBook(laptopBrand);
        MacBookPage macBookPage = new MacBookPage(driver);
        macBookPage.validateHeaders(laptopBrand,laptopPrice,laptopDesc);
        macBookPage.clickaddToCart(driver,message);
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
