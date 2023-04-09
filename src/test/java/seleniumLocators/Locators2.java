package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/gucci/Downloads/Techtorialhtml.html");

        //LINKTEXT LOCator
        WebElement javaLink = driver.findElement(By.linkText("Java"));// a tag with the text
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println( header.getText().trim().equals("Java") ? "Passed" : "Failed");
        Thread.sleep(3000);
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement headerSelenium = driver.findElement(By.tagName("h1"));
        System.out.println(headerSelenium.getText().trim().equals("Selenium automates browsers. That's it!") ? "passed selenium" : "Failed");

        driver.navigate().back();
        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement headerCucumber = driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "passed cucumber" : "failed");

        driver.navigate().back();
        WebElement textNGLink = driver.findElement(By.linkText("TestNG"));
        textNGLink.click();
        WebElement headerTestNG = driver.findElement(By.tagName("h2"));
        System.out.println(headerTestNG.getText().trim().equals("TestNG") ? "passed testNG" : "failed");

        driver.navigate().back();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "file:///Users/gucci/Downloads/Techtorialhtml.html";
        System.out.println(actualURL.equals(expectedURL) ? "passed URL" : "FAILED");

        //Partial LINK TEXT locator  --> must have a tag and text

        WebElement restAPI = driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        String actualURLRestApi = driver.getCurrentUrl();
        String expectedURLRestAPI = "https://rest-assured.io/";
        System.out.println(actualURLRestApi.equals(expectedURLRestAPI) ? "passed" : "failed");

        driver.close();







    }
}
