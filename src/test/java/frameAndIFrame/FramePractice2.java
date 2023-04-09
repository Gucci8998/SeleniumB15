package frameAndIFrame;

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
import java.util.List;

public class FramePractice2 {
    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchById(driver);
        WebElement seleniumButton = driver.findElement(By.xpath("//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumButton).perform();
        WebElement seleniumJava = driver.findElement(By.xpath("//span[.='Selenium-Java']"));
        seleniumJava.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Java Tutorial – Basic to Advance");
        Thread.sleep(3000);
        List<WebElement> tableOfContent = driver.findElements(By.xpath("//div[@class='htoc__itemswrap']//li"));
             for(WebElement element: tableOfContent){
                 System.out.println(BrowserUtils.getText(element));
             }

        BrowserUtils.switchByTitle(driver,"iframes");
             driver.switchTo().frame("Frame1");
             WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));
             category1.click();
             BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");
             WebElement headerofCategory1 = driver.findElement(By.tagName("h1"));
             Assert.assertEquals(BrowserUtils.getText(headerofCategory1),"Category Archives: SeleniumTesting");
        Thread.sleep(3000);
             List<WebElement> headers = driver.findElements(By.xpath("//div[@class='post-entry-content']"));
             for (WebElement headerofSelenium: headers){
                 System.out.println(BrowserUtils.getText(headerofSelenium));
             }

        BrowserUtils.switchByTitle(driver,"iframes");
             driver.switchTo().frame("Frame2");
             WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
             category3.click();
             BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives -");
             WebElement headerofCategory3 = driver.findElement(By.tagName("h1"));
             Assert.assertEquals(BrowserUtils.getText(headerofCategory3),"Category Archives: SoftwareTesting");
    }
}
