package homeWorkSelenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[.='Yes']"));
        yesButton.click();
        WebElement text = driver.findElement(By.xpath("//p[@class = 'mt-3']"));
        System.out.println(text.getText().trim().equals("You have selected Yes")? "PASSED": "FAILED");
        Thread.sleep(3000);
        WebElement impressiveButton = driver.findElement(By.xpath("//label[.='Impressive']"));
        impressiveButton.click();
        WebElement text2 = driver.findElement(By.xpath("//p[@class = 'mt-3']"));
        System.out.println(text2.getText().trim().equals("You have selected Impressive")? "PASSED": "FAILED");

    }
}
