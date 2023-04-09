package com.test.sauce.tests;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name = "negativeLogin")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"problem_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"wrong_username","wrong_password","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @DataProvider(name = "productInfo")
    public Object[][] getProductInfo(){
        return new Object[][]{
                {"Sauce Labs Backpack","streamlined Sly Pack","29.99"},
                {"Sauce Labs Bike Light","red light","9.99"},
                {"Sauce Labs Bolt T-Shirt","bolt T-shirt","15.99"},
                {"Sauce Labs Fleece Jacket","fleece jacket","49.99"},
                {"Sauce Labs Onesie","infant onesie","7.99"},
                {"Test.allTheThings() T-Shirt (Red)","classic Sauce","15.99"}
        };
    }

    @DataProvider(name = "buyProduct")
    public Object[][] addtoCartProduct(){
        return new Object[][]{
                {"Sauce Labs Backpack","29.99"},
                {"Sauce Labs Bike Light","9.99"},
                {"Sauce Labs Bolt T-Shirt","15.99"},
                {"Sauce Labs Fleece Jacket","49.99"},
                {"Sauce Labs Onesie","7.99"},
                {"Test.allTheThings() T-Shirt (Red)","15.99"}
        };
    }
}
