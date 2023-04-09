package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(tagName = "td")
    List<WebElement> productInfo;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrder;

    public void validateInfo(String title, String price) throws InterruptedException {
        List<String> expectedInfo = Arrays.asList("",title,price,"");
        Thread.sleep(2000);
        for (int i = 1; i<productInfo.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(productInfo.get(i)),expectedInfo.get(i));
        }
    }
    public void clickPlaceOrder(){
        placeOrder.click();
    }
}
