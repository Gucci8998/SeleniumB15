package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeappointment = driver.findElement(By.xpath("//a[@id= 'btn-make-appointment']"));
        makeappointment.click();

        WebElement demoUserName =driver.findElement(By.xpath("//input[@aria-describedby = 'demo_username_label']"));
        System.out.println(demoUserName.getText().trim());
        System.out.println(demoUserName.getAttribute("value"));
        System.out.println(demoUserName.getAttribute("placeholder"));
    }
}
