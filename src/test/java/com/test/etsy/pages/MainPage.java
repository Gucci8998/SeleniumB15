package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='search_query']")
    WebElement searchBar;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allCases;

    public void findIphone13case(String searchItem,String keyword1, String keyword2,String keyword3){
        searchBar.sendKeys(searchItem);
        searchBar.sendKeys(Keys.ENTER);
        for (WebElement cases : allCases){
            String word=BrowserUtils.getText(cases).toLowerCase();
            Assert.assertTrue(word.contains(keyword1) || word.contains(keyword2) || word.contains(keyword3));

        }
    }
}
