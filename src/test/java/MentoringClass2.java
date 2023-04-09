import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MentoringClass2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.facebook.com/");
        WebElement newAccount = driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']"));
        newAccount.click();
        WebElement name = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        name.sendKeys("Gg");
        WebElement lastName = driver.findElement(By.xpath("//input[@name = 'lastname']"));
        lastName.sendKeys("Ibraeva");
        WebElement email = driver.findElement(By.xpath("//input[@name = 'reg_email__']"));
        email.sendKeys("gg@gmail.com");
        WebElement reEnterEmail = driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']"));
        reEnterEmail.sendKeys("gg@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
        password.sendKeys("123456Gg");
        WebElement day = driver.findElement(By.xpath("//select[@id ='day']"));
        day.sendKeys("25");
        WebElement month = driver.findElement(By.xpath("//select[@id ='month']"));
        month.sendKeys("dec");
        WebElement year = driver.findElement(By.xpath("//select[@id ='year']"));
        year.sendKeys("1998");
        WebElement custom = driver.findElement(By.xpath("//label[.='Custom']"));
        custom.click();
        WebElement pronoun = driver.findElement(By.xpath("//select[@name ='preferred_pronoun']"));
        pronoun.sendKeys("She: Wish her a happy birthday!");
//        WebElement she = driver.findElement(By.xpath("//option[contains(text(), 'Wish her a happy birthday!')]"));
//        she.click();
        WebElement signUp = driver.findElement(By.xpath("//button[@name = 'websubmit']"));
        signUp.click();
        Thread.sleep(3000);




    }
}
