package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchHomeWork {
    @Test
    public void validateHeader() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourseButton = driver.findElement(By.xpath("//span[contains(text(),'Find')]//.."));
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,findCourseButton);
        BrowserUtils.clickWithJS(driver,findCourseButton);
        String mainPageID = driver.getWindowHandle();
        Set<String> getAllPagesID = driver.getWindowHandles();
        for (String id: getAllPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle =driver.getTitle();
        String expectedTitle = "Courses";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println(actualTitle);

    }

}
