package frameAndIFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FramePractice {

    @Test
    public void iFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header),"An iFrame containing the TinyMCE WYSIWYG Editor");
        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");
        WebElement textClear = driver.findElement(By.cssSelector("#tinymce"));
        textClear.clear();
        textClear.sendKeys("I Love Selenium");
      //  driver.switchTo().window(driver.getWindowHandle()); //withId
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        elementalSelenium.click();
        BrowserUtils.switchById(driver);
        WebElement headerNew = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(headerNew),"Elemental Selenium");
    }
}
