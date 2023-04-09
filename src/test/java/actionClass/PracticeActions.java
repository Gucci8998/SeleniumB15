package actionClass;

import com.beust.ah.A;
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

public class PracticeActions {
    @Test
    public void validateMessageAndColor() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement droppedBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement dragBox= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200,200);
        Thread.sleep(1000);
        actions.dragAndDrop(dragBox,droppedBox).perform();

        String actualColor = droppedBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        droppedBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(droppedBox);
        String expectedMessage ="Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void ClickAndHoldMethodPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
Thread.sleep(2000);
        WebElement accept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();
        WebElement notAcceptableBox = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200,200);
        String actualMessage = BrowserUtils.getText(notAcceptableBox);
        String expectedMessage = "Not Acceptable";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement droppedBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        actions.clickAndHold(notAcceptableBox).moveToElement(droppedBox).release().perform();

        Thread.sleep(1000);
        String actualMessagefromDropped = BrowserUtils.getText(droppedBox);
        String expectedMessagefromDropped = "Drop here";
        Assert.assertEquals(actualMessagefromDropped,expectedMessagefromDropped);



    }

}
