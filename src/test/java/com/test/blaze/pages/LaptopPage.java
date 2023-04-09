package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//h4//a")
    List<WebElement> allLaptops;

    public void chooseMacBook(String model) throws InterruptedException {
        Thread.sleep(2000);
        for (WebElement laptop: allLaptops){
            if(BrowserUtils.getText(laptop).contains(model)){
                laptop.click();
                break;
            }
        }
    }


}
