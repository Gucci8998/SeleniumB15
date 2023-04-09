package com.test.bank.pages;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerPage {

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerForm;


    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;

    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement selectYourName;

    @FindBy(xpath = "//select[@name='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement process;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customerButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBar;

    @FindBy(xpath = "//tr//td[@class='ng-binding']")
    List<WebElement> allInfoaboutCustomer;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;


    public void addCustomer(String firstName, String lastName, String postCode){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        addCustomerForm.click();
    }

    public void OpenAccount(){
        openAccount.click();
    }
    public void selectName(String firstName){
        BrowserUtils.selectBy(selectYourName,firstName,"text");
    }
    public void selectCurrencyandProcess(){
        BrowserUtils.selectBy(currency,"Dollar","value");
        process.click();
    }
    public void openCustomerButton(String searchBar,String name, String lastName, String postCode){
        customerButton.click();
        this.searchBar.sendKeys(searchBar);
        List<String> expectedInfo= Arrays.asList(name,lastName,postCode);
        for (int i = 0; i<expectedInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInfoaboutCustomer.get(i)),expectedInfo.get(i));
        }
        deleteButton.click();
    }



}
