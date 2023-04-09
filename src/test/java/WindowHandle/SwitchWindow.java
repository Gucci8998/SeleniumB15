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

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement click = driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();
        String mainPageID = driver.getWindowHandle();
        System.out.println(mainPageID); //CDwindow-79D8B1EA9DA6A75EE4DC3A6D0E05A706
        Set<String> allPagesID = driver.getWindowHandles();
        System.out.println(allPagesID);

        for (String id: allPagesID){
            //this is used for only 2 tabs/windows
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }
/*TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Click click me button
  6-Quit the tabs
 */
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTab = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        newTab.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id: allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String newTabTitle= driver.getTitle();
        String expectedTitle ="AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(newTabTitle,expectedTitle);
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header),"AlertsDemo");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
        Thread.sleep(2000);
        driver.quit();

    }
}

