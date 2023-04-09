package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed. done
1-Navigate to the website done
2-Choose the "New Cars" from the New/used option done
3-Choose "Lexus" for Make part done
4-Choose "RX-350" done
5-Validate the Price is selected "No max price"-->getFirstSelectedOption   done
6-Choose the distance 40 mil done
7-Put your Zip code-->Before that Clear it.60056 done
8-Click Search Button done
9-Validate the header "New Lexus RX 350 for sale" done
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */
    @Test
    public void validateHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        WebElement newUsedBox = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsedBox,"New", "text");
        Thread.sleep(2000);
        WebElement brandBox = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(brandBox, "lexus","value");
        Thread.sleep(2000);
        WebElement modelBox = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelBox,"lexus-rx_350", "value");
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceFirst = new Select(price);
        String actualPrice = priceFirst.getFirstSelectedOption().getText().trim();
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        Thread.sleep(2000);
        WebElement zipcode = driver.findElement(By.xpath("//input[@id ='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchButton.click();
        WebElement header1 = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualHeader = BrowserUtils.getText(header1);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement sortButton = driver.findElement(By.xpath("//select[@id = 'sort-dropdown']"));
        BrowserUtils.selectBy(sortButton,"Lowest price", "text");
        Thread.sleep(2000);
        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[contains(text(),'Lexus RX 350')]"));
        for (WebElement car: allTitles){
           Assert.assertTrue( BrowserUtils.getText(car).contains("Lexus RX 350"));
        }


        List<WebElement> prices = driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPrices = new ArrayList<>();
        List<Integer> expectedPrices = new ArrayList<>();
        for (int i = 0; i<prices.size();i++){
            actualPrices.add(Integer.parseInt(prices.get(i).getText().trim().replace("$","").replace(",","")));
            expectedPrices.add(Integer.parseInt(prices.get(i).getText().trim().replace("$","").replace(",","")));

        }
        Collections.sort(expectedPrices);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);


    }
}
