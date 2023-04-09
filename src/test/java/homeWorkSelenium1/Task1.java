package homeWorkSelenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(3000);
        WebElement fullName = driver.findElement(By.xpath("//input[@id ='userName']"));
        fullName.sendKeys("Gulmira Ibraeva");
        WebElement email = driver.findElement(By.xpath("//input[@id ='userEmail']"));
        email.sendKeys("gucci1234@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id ='currentAddress']"));
        currentAddress.sendKeys("Des Plaines");
        currentAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id ='permanentAddress']"));
        permanentAddress.sendKeys("Des Plaines)");
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(3000);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.click();
        Thread.sleep(3000);

        WebElement par = driver.findElement(By.xpath("//p[@id ='name']"));
        System.out.println(par.getText().trim().equals("Name:Gulmira Ibraeva") ? "PASSED": "FAILED");
        WebElement par2 = driver.findElement(By.xpath("//p[@id ='email']"));
        System.out.println(par2.getText().trim().equals("Email:gucci1234@gmail.com")? "PASSED" : "FAILED");
        WebElement par3 = driver.findElement(By.xpath("//p[@id ='currentAddress']"));
        System.out.println(par3.getText().trim().equals("Current Address :Des Plaines") ? "passed" : "failed");
        WebElement par4 = driver.findElement(By.xpath("//p[@id ='permanentAddress']"));
        System.out.println(par4.getText().trim().equals("Permananet Address :Des Plaines)") ? "Passed" : "failed");






    }
}
