package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookPage {

    public MacBookPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement header1;

    @FindBy(tagName = "h3")
    WebElement header2;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement paragraph;

    @FindBy(xpath = "//a[contains(text(),'Add')]")
    WebElement addToCartButton;


    public void validateHeaders(String header1, String header2, String paragraph){
        Assert.assertEquals(BrowserUtils.getText(this.header1),header1);
        Assert.assertTrue(BrowserUtils.getText(this.header2).contains(header2));
        Assert.assertTrue(BrowserUtils.getText(this.paragraph).contains(paragraph));
    }
    public void clickaddToCart(WebDriver driver,String expected) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expected);
        alert.accept();
    }
}
