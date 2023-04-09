package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Laptops")
    WebElement laptopsButton;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartButton;

    public void clickLaptop(){
        laptopsButton.click();
    }
    public void presscartButton(){
        cartButton.click();
    }

}
