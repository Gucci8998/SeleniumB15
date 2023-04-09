package com.test.sauce.tests;

import com.test.sauce.pages.ProductPage;
import com.test.sauce.pages.SauceLoginPage;
import org.testng.Assert;

import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductTest extends TestBaseSauce{

    @Test(dataProvider = "productInfo", dataProviderClass = AllData.class )
    public void validateProductInfo(String productName, String description, String price){

        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("OA_username"),ConfigReader.readProperty("OA_password"));
        ProductPage productPage =new ProductPage(driver);
        productPage.findProduct(productName, description, price);
    }
}
