package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionClassPractice1 {
    @Test
    public void validateMoveTo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        WebElement ccokies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        ccokies.click();
        Actions actions = new Actions(driver);
        //actions.click(ccokies).perform();
        List<WebElement> images = driver.findElements(By.xpath("//div[@class = 'product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class = 'product-description']//h3"));
        List<WebElement>  allPrices = driver.findElements(By.xpath("//div[@class = 'product-description']//p"));
        actions.scrollByAmount(200,200);
        Map<String,String> products = new HashMap<>();
        for (int i = 0; i<allNames.size();i++){
            Thread.sleep(400);
            actions.moveToElement(images.get(i)).perform();
            products.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(products);
       // List<String> actualNames = new ArrayList<>();
        //List
    }
}
