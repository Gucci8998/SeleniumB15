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

public class HTMLPopUp {
    @Test
    public void htmlPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        WebElement alertPreview = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        alertPreview.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();
        WebElement preview2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();

        WebElement message = driver.findElement(By.xpath("//div[@class='swal-text']"));
        Assert.assertTrue(BrowserUtils.getText(message).contains("Something went wrong!"));
        WebElement okButton = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();

    }
}
