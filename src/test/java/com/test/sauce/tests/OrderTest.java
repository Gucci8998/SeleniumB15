package com.test.sauce.tests;

import com.test.sauce.pages.CheckoutPage;
import com.test.sauce.pages.ProductPage;
import com.test.sauce.pages.SauceLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class OrderTest extends TestBaseSauce {
 //   @Parameters({"firstName","lastName","zipcode","message"})

    @Test(dataProvider = "buyProduct",dataProviderClass = AllData.class)
    public void validateOrderTest(String productName, String price){
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("OA_username"),ConfigReader.readProperty("OA_password"));
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart(productName,price);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.orderProduct("GG","VV","1234","Thank you for your order!");
    }
}
