package JavaScriptExecutor;

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

public class JavaScriptMethods {

    //We use JavaScript methods when Selenium methods are not working as expected.
    //Specifically : click, getTitle
    //NOTE: We love using ScrollIntoView Method from JavaScript in professional environment

    @Test
    public void getTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle() + " This is regular driver method for title ");
        //if this one is not working we need to use JS method
        JavascriptExecutor js = (JavascriptExecutor) driver; //your driver is acting like JS executor
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " This is JS method for title");

    }
    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        WebElement text = driver.findElement(By.xpath("//p[@class = 'mt-3']"));
       String actualMessage = BrowserUtils.getText(text);
       String expectedMEssAGE = "You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMEssAGE);
Thread.sleep(2000);
        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()",impressiveButton);
        String aactualImpressiveMessage = BrowserUtils.getText(text);
        String expectedImpressiveMessage = "You have selected Impressive";
        Assert.assertEquals(aactualImpressiveMessage,expectedImpressiveMessage);

    }
    //this one is all about scrolling the page based on the location of element
    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourseButton = driver.findElement(By.xpath("//span[contains(text(),'Find')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourseButton); //***
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", findCourseButton); //**
        System.out.println(js.executeScript("return document.title")); //*

    }
    @Test
    public void ShortCutJSMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourseButton = driver.findElement(By.xpath("//span[contains(text(),'Find')]//.."));
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,findCourseButton);
        BrowserUtils.clickWithJS(driver,findCourseButton);
        BrowserUtils.getTitleWithJS(driver);


    }
}
