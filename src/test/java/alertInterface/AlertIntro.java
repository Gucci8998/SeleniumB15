package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
                                                  // or "//button[contains(@onclick,'jsAlert')]"
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String actualJSALertText = alert.getText();
        String expectedJSAlertText = "I am a JS Alert";
        Assert.assertEquals(actualJSALertText,expectedJSAlertText);
        Thread.sleep(2000);
        alert.accept();
        WebElement result= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(result),"You successfully clicked an alert");
        Thread.sleep(2000);
        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm.click();
        String actualJsConfirm = alert.getText();
        Assert.assertEquals(actualJsConfirm,"I am a JS Confirm");
        alert.accept();

    }

    @Test
    public void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm.click();
        Alert alert = driver.switchTo().alert();
        String actualJsConfirm = alert.getText();
        Assert.assertEquals(actualJsConfirm,"I am a JS Confirm");
        alert.dismiss();
        WebElement result= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(result),"You clicked: Cancel");

    }

    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jSPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(2000);
        alert.accept();
        WebElement result= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(result),"You entered: hello");

    }
}
