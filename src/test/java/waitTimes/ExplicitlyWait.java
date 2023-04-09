package waitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {


        WebDriver driver;

        @Test
        public void explicitlyWaitPractice(){
            driver = DriverHelper.getDriver();
            driver.get("https://the-internet.herokuapp.com/");
            WebElement element1 = driver.findElement(By.linkText("Dynamic Loading"));
            element1.click();
            WebElement example1 = driver.findElement(By.xpath("//a[contains(text(),'Example 1')]"));
            example1.click();
            WebElement buttonStart = driver.findElement(By.tagName("button"));
            buttonStart.click();
            WebElement message = driver.findElement(By.xpath("//div[@id='finish']//h4"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            message = wait.until(ExpectedConditions.visibilityOf(message));
            Assert.assertEquals(BrowserUtils.getText(message),"Hello World!");
        }

        @Test
        public void validateText2(){
            driver = DriverHelper.getDriver();
            driver.get("https://the-internet.herokuapp.com/");
            WebElement element1 = driver.findElement(By.linkText("Dynamic Controls"));
            element1.click();
            WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            checkBox.click();
            WebElement remove = driver.findElement(By.xpath("//button[.='Remove']"));
            remove.click();
            WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//            WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
//            message2 = wait.until(ExpectedConditions.visibilityOf(message2));
            Assert.assertEquals(BrowserUtils.getText(message2),"It's gone!");

        }

}
