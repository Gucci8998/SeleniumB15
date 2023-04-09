package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //driver.get();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("your test is passed");
        }else {
            System.out.println("your test is failed");
        }
        //driver.getCurrentUrl()
        driver.get("https://www.techtorialacademy.com/");
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.techtorialacademy.com/";
        String actualTitleTechtorial = driver.getTitle();
        String expectedTitleTechtorial = "Home";
        if(actualURL.equals(expectedUrl)){
            System.out.println("URL IS PASSED");
        } else {
            System.out.println("URL IS FAILED");
        }

        if(actualTitleTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("TITLE IS PASSED");
        } else {
            System.out.println("TITLE IS FAILED");
        }
        driver.close();

    }
}
