package com.test.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#checkout")
    WebElement checkout;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;

    @FindBy(tagName = "h2")
    WebElement messageConfirmation;

    public void orderProduct(String firstName, String lastName, String postalCode,String expectedmessage){
        checkout.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipcode.sendKeys(postalCode);
        continueButton.click();
        finishButton.click();
        Assert.assertEquals(BrowserUtils.getText(messageConfirmation),expectedmessage);
    }


}
