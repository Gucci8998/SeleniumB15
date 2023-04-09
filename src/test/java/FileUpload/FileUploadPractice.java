package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/gucci/Desktop/usa.png");

        WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header),"File Uploaded!");

        WebElement nameofFile = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(nameofFile),"usa.png");
    }

    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement choosefile = driver.findElement(By.xpath("//input[@type='file']"));
        choosefile.sendKeys("/Users/gucci/Desktop/usa.png");
        WebElement maxCapacity = driver.findElement(By.xpath("//b[contains(text(),'Select')]"));
        Assert.assertEquals(BrowserUtils.getText(maxCapacity),"Select file to send(max 196.45 MB)");
        WebElement accept = driver.findElement(By.cssSelector("#terms"));
        accept.click();
        WebElement submit = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submit.click();
        WebElement message = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(BrowserUtils.getText(message).contains("has been successfully uploaded."));
    }


}
