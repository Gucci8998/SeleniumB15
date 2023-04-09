package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPracticeXpath {
    public static void main(String[] args) {
        //1- Setup automation
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        //2 - Automation process
        WebElement firstName= driver.findElement(By.xpath("//input[@id = 'input-firstname']"));
        firstName.sendKeys("Gigi");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Ibraeva");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder = 'E-Mail']"));
        email.sendKeys("gigiG89981425@gmail.com");

        WebElement telephone = driver.findElement(By.xpath("//input[@type = 'tel']"));
        telephone.sendKeys("777888444");

        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("gigi1234");

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id = 'input-confirm']"));
        passwordConfirm.sendKeys("gigi1234");

        WebElement checkbox = driver.findElement(By.xpath("//input[@name = 'agree']"));
        checkbox.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value = 'Continue']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");






    }
}
