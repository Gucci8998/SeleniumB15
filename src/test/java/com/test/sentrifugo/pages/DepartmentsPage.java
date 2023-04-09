package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class DepartmentsPage {
    public DepartmentsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@title='Add']")
    WebElement add;


    @FindBy(xpath = "//input[@id='deptname']")
    WebElement departmentName;

    @FindBy(css = "#s2id_unitid")
    WebElement businessUnit;

    @FindBy(xpath = "//span[.='Orange Blossom']")
    WebElement orangeBlossom;

    @FindBy(css = "#deptcode")
    WebElement departmentCode;

    @FindBy(css = "#submitbutton")
    WebElement saveButton;

    @FindBy(css = ".ml-alert-1-success")
    WebElement message;

    @FindBy(xpath = "//tbody//tr[1]//td//span")
    List<WebElement> addedInfo;

    public void validateDepartmentFunctionality(String departmentName,String departmentCode,String expectedmessage){
        add.click();
        this.departmentName.sendKeys(departmentName);
        businessUnit.click();
        orangeBlossom.click();
        this.departmentCode.sendKeys(departmentCode);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedmessage);
    }

    public void validateTableInfofromList(String name, String code, String started_on, String departmentHead,
                                          String timeZone, String businessUnit){
        List<String> expectedInfo = Arrays.asList(name,code,started_on,departmentHead,timeZone,businessUnit);
        for (int i =0; i<expectedInfo.size();i++){
          Assert.assertEquals(BrowserUtils.getText(addedInfo.get(i)),expectedInfo.get(i));
            System.out.println(BrowserUtils.getText(addedInfo.get(i)));
            System.out.println(expectedInfo.get(i));
        }
    }


}
