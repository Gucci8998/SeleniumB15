package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragandDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(1000);
        WebElement ccokies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        ccokies.click();

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualcolorOfBox = orangeBox.getCssValue("background-color");
        String expectedcolorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualcolorOfBox,expectedcolorOfBox);

        WebElement draggerCircle = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        actions.dragAndDrop(draggerCircle,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageafterDragandDrop = BrowserUtils.getText(orangeBox);
        String expectedMessageafterDragAndDrop = "You did great!";
        Assert.assertEquals(actualMessageafterDragandDrop,expectedMessageafterDragAndDrop);




    }
    @Test
    public void clickAndHoldRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(1000);
        WebElement ccokies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        ccokies.click();

        WebElement blueBox = driver.findElement(By.xpath("//div[@class = 'test1']"));
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);

        WebElement draggerCircle = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200,200);
        actions.clickAndHold(draggerCircle).moveToElement(blueBox).release().perform();
        Thread.sleep(2000);
        blueBox=driver.findElement(By.xpath("//div[@class = 'test1']"));
        String actualMessageafterClickandHold = BrowserUtils.getText(blueBox);
        String expectedMessageafterClickandHold = "You did great!";
        Assert.assertEquals(actualMessageafterClickandHold,expectedMessageafterClickandHold);





    }

}
