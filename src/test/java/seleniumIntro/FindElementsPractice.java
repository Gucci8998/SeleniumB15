package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> alllinks = driver.findElements(By.tagName("li"));
        for (WebElement link: alllinks){
            System.out.println(link.getText());

        }
        System.out.println( alllinks.size());

        System.out.println("++++++++++++++++ Part 2 ++++++++");
        int counter = 0;
        for (WebElement link: alllinks){
            if(link.getText().length()>= 12){
                System.out.println(link.getText());
            counter++;
            }
        }
        System.out.println(counter);
        driver.close();
    }
}
