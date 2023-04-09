package com.test.blaze.pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement purchaseConfirmation;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void placeOrderInfo(String name, String country, String city, String creditCard, String month, String year){
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
    }
    public void validatePurchaseSuccessfullydone(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(purchaseConfirmation),expectedMessage);
        Thread.sleep(2000);
        okButton.click();
       // Thread.sleep(2000);
    }
}
