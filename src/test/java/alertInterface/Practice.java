package alertInterface;

import com.beust.ah.A;
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

public class Practice {
    @Test
    public void alertPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement clickme1 = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickme1.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();

        WebElement result1 = driver.findElement(By.xpath("//div[@id='output']"));
        Assert.assertEquals(BrowserUtils.getText(result1),"You selected alert popup");
        Thread.sleep(2000);
        WebElement clickMe2 = driver.findElement(By.xpath("//button[@id='confirmBox']"));
        clickMe2.click();
        alert.dismiss();
        WebElement result2 = driver.findElement(By.xpath("//div[@id='output']"));
        Assert.assertEquals(BrowserUtils.getText(result2),"You pressed Cancel in confirmation popup");
        Thread.sleep(2000);
        WebElement clickMe3 = driver.findElement(By.xpath("//button[@id='promptBox']"));
        clickMe3.click();
        alert.sendKeys("Gulmira");
        alert.accept();
        WebElement result3 =  driver.findElement(By.xpath("//div[@id='output']"));
        Assert.assertEquals(BrowserUtils.getText(result3),"You entered text Gulmira in propmt popup");

    }
}
