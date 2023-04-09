import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MentoringClass3 {
    @Test
    public void validateDishName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.thespruceeats.com/");
        WebElement ingredients = driver.findElement(By.xpath("//span[.='Ingredients']"));
        Actions actions = new Actions(driver);
        WebElement fishSeafood = driver.findElement(By.xpath("//li[@class='global-nav__sub-list-item']//a[contains(text(),'Fish & Seafood')]"));
        actions.moveToElement(ingredients).perform();
        fishSeafood.click();
        Thread.sleep(3000);
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search-form-input']"));
       //actions.scrollToElement(searchBar);
        BrowserUtils.scrollWithJS(driver,searchBar);
        searchBar.sendKeys("Fish for dinner", Keys.ENTER);
        WebElement stars1 = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        stars1.click();
        WebElement popular = driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        popular.click();
        Thread.sleep(2000);
        WebElement nameofDish = driver.findElement(By.xpath("//span[.='6-Ingredient Roasted Salmon Fillets']"));
        String actualName = BrowserUtils.getText(nameofDish);
        String expectedName = "6-Ingredient Roasted Salmon Fillets";
        Assert.assertEquals(actualName,expectedName);
        Thread.sleep(3000);
        driver.close();



    }
}
