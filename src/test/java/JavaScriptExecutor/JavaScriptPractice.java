package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {
    @Test
    public void practiceWithJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyright = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyright);
        String actualMessage = BrowserUtils.getText(copyright);
        String expectedMessage = "Copyright © 2023";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(2000);
        WebElement apply = driver.findElement(By.xpath("//strong[.='APPLY NOW']//.."));
        BrowserUtils.scrollWithJS(driver,apply);
        apply.click();
        List<WebElement> information = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> actualInfo=new ArrayList<>();
        List<String> expectedinfo = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        for (int i = 0; i<information.size();i++){
            actualInfo.add(BrowserUtils.getText(information.get(i)));
Assert.assertEquals(actualInfo.get(i),expectedinfo.get(i));
        }
    }
}
