package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void validateFirstOptionAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/gucci/Downloads/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name = 'country']"));
        //countryBox.sendKeys(Keys.ARROW_DOWN);
        Select option = new Select(countryBox);
        System.out.println(option.getFirstSelectedOption().getText().trim());
        String actual= option.getFirstSelectedOption().getText().trim();
        String expected = "UNITED STATES";
        Assert.assertEquals(actual, expected);

        List<WebElement> allTheCountries = option.getOptions();
        for (WebElement countryName: allTheCountries){
            System.out.println(countryName.getText().trim());
        }
        System.out.println(allTheCountries.size());

        option.selectByVisibleText("KYRGYZSTAN");
       Thread.sleep(3000);
      option.selectByIndex(0);
      Thread.sleep(3000);
       option.selectByValue("100");
        Thread.sleep(3000);

    }


}
