package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindows {
@Test
    public void multipleWindowsPractice() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.open('http://www.techtorialacademy.com/')");
    js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
    js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
   BrowserUtils.switchByTitle(driver,"Contact us");
   Thread.sleep(3000);
   BrowserUtils.switchByTitle(driver,"Home");
   Thread.sleep(3000);
   BrowserUtils.switchByTitle(driver,"Courses");

}

@Test
    public void task2() throws InterruptedException {
       /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html done
2-Click open multiple tabs under Button 4 done
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful" done
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
    button4.click();
    BrowserUtils.switchByTitle(driver,
            "Basic Controls - H Y R Tutorials");
    WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
    firstName.sendKeys("Gg");
    WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
    lastName.sendKeys("Ibraeva");
    WebElement gender = driver.findElement(By.xpath("//input[@id='femalerb']"));
    gender.click();
    WebElement language1 = driver.findElement(By.xpath("//input[@id='englishchbx']"));
    language1.click();
    WebElement language2 = driver.findElement(By.xpath("//input[@id='spanishchbx']"));
    language2.click();
    WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
    email.sendKeys("gg1234@gmail.com");
    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
    password.sendKeys("123456Gg");
    WebElement register = driver.findElement(By.xpath("//button[@id='registerbtn']"));
    BrowserUtils.scrollWithJS(driver,register);
    register.click();
    WebElement message = driver.findElement(By.xpath("//label[.='Registration is Successful']"));
    Assert.assertEquals(BrowserUtils.getText(message),"Registration is Successful");
    BrowserUtils.switchByTitle(driver,
            "Window Handles Practice - H Y R Tutorials");
    WebElement header1 = driver.findElement(By.xpath("//h1[contains(text(),'Window')]"));
    Assert.assertEquals(BrowserUtils.getText(header1),
            "Window Handles Practice");
    BrowserUtils.switchByTitle(driver,
            "AlertsDemo - H Y R Tutorials");
    WebElement clickMe = driver.findElement(By.xpath("//button[@id='promptBox']"));
    clickMe.click();
    Thread.sleep(2000);
    driver.quit();



}
}
