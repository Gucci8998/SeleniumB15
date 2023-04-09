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
import java.util.Arrays;
import java.util.List;

public class SelectPractice2 {
    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement dropDown1 = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengers = new Select(dropDown1);
        passengers.selectByVisibleText("4 ");
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name ='fromPort']"));
        Select departingFrom = new Select(dropdown2);
        String defaultDeparting = departingFrom.getFirstSelectedOption().getText().trim();
        String expectedDeparting = "Acapulco";
        Assert.assertEquals(defaultDeparting,expectedDeparting);
        departingFrom.selectByVisibleText("Paris");
        WebElement dropdown3 = driver.findElement(By.xpath("//select[@name ='fromMonth']"));
        Select date = new Select(dropdown3);
        date.selectByIndex(7);
        WebElement dropdown4 = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select day = new Select(dropdown4);
        day.selectByValue("15");
        WebElement dropdown5 = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrival = new Select(dropdown5);
        arrival.selectByVisibleText("San Francisco");
        WebElement dropdown6 = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returning = new Select(dropdown6);
        returning.selectByValue("12");
        WebElement dropdown7 = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDay = new Select(dropdown7);
        returningDay.selectByValue("15");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement airlinesAll = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlines = new Select(airlinesAll);
        List<WebElement> airlinesList = airlines.getOptions();
        List<String> airlinesExpected = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i<airlinesList.size(); i++){
        Assert.assertEquals(airlinesList.get(i).getText().trim(), airlinesExpected.get(i));
        }
        airlines.selectByIndex(2);
        WebElement continueButton = driver.findElement(By.xpath("//input[@name ='findFlights']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        System.out.println(message.getText().trim());
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual,expected);



    }

    @Test
    public void shortCutSelectClass(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement dropDown1 = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(dropDown1, "3", "index");
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name ='fromPort']"));
        Select departingFrom = new Select(dropdown2);
        String defaultDeparting = departingFrom.getFirstSelectedOption().getText().trim();
        String expectedDeparting = "Acapulco";
        Assert.assertEquals(defaultDeparting,expectedDeparting);
        BrowserUtils.selectBy(dropdown2, "Paris", "text");
        WebElement dropdown3 = driver.findElement(By.xpath("//select[@name ='fromMonth']"));
        BrowserUtils.selectBy(dropdown3, "8", "value");
        WebElement dropdown4 = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dropdown4, "14", "index");
        WebElement dropdown5 = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(dropdown5, "San Francisco", "text");
        WebElement dropdown6 = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(dropdown6, "12", "value");
        WebElement dropdown7 = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(dropdown7, "15","value");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement airlinesAll = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlines = new Select(airlinesAll);
        List<WebElement> airlinesList = airlines.getOptions();
        List<String> airlinesExpected = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i<airlinesList.size(); i++){
            Assert.assertEquals(airlinesList.get(i).getText().trim(), airlinesExpected.get(i));
        }
        airlines.selectByIndex(2);
        WebElement continueButton = driver.findElement(By.xpath("//input[@name ='findFlights']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        System.out.println(message.getText().trim());
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void multiSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/gucci/Downloads/Techtorialhtml.html");

        WebElement countryBoxLocation = driver.findElement(By.cssSelector(".select"));
        Select country = new Select(countryBoxLocation);
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
        country.deselectByVisibleText("One");
        Thread.sleep(2000);
        country.deselectAll();


    }
}
