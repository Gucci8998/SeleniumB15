import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MentoringClass4 {
    @Test
    public void validationCostFunctionality(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        WebElement birds = driver.findElement(By.xpath("//map[@name='estoremap']//area[@alt='Birds']"));
        birds.click();

        Map<String,String>  catalog = new LinkedHashMap<>();
        List<WebElement> birdsInfo = driver.findElements(By.xpath("//a[contains(text(),'AV')]"));
        List<WebElement> birdsName = driver.findElements(By.xpath("//td[contains(text(),'n')]"));
        for(int i= 0; i<birdsName.size();i++){
            catalog.put(BrowserUtils.getText(birdsInfo.get(i)),BrowserUtils.getText(birdsName.get(i)));
        }
        System.out.println(catalog);
        WebElement returntoMainMenu = driver.findElement(By.xpath("//a[.='Return to Main Menu']"));
        returntoMainMenu.click();
        birds = driver.findElement(By.xpath("//map[@name='estoremap']//area[@alt='Birds']"));
        birds.click();
        WebElement id1 = driver.findElement(By.xpath("//a[.='AV-CB-01']"));
        id1.click();
        WebElement addToCart1 = driver.findElement(By.xpath("//a[.='Add to Cart']"));
        addToCart1.click();
        returntoMainMenu = driver.findElement(By.xpath("//a[.='Return to Main Menu']"));
        returntoMainMenu.click();
        WebElement dogs = driver.findElement(By.xpath("//area[@alt='Dogs']"));
        dogs.click();
        WebElement id2 = driver.findElement(By.xpath("//a[.='K9-RT-01']"));
        id2.click();
        WebElement addtoCart2 = driver.findElement(By.xpath("//a[.='Add to Cart']"));
        addtoCart2.click();

        //Math functionality
        WebElement price1 = driver.findElement(By.xpath("//td[.='$193.50']"));
        WebElement price2 = driver.findElement(By.xpath("//td[.='$155.29']"));
        double priceofBird = Double.parseDouble(BrowserUtils.getText(price1).replace("$",""));
        double priceofDog= Double.parseDouble(BrowserUtils.getText(price2).replace("$",""));
        WebElement totalPrice = driver.findElement(By.xpath("//td[.='Sub Total: $348.79 ']"));
        DecimalFormat decimalFormat=new DecimalFormat("##.##");
        double sumofPrices = priceofBird+priceofDog;
        System.out.println(decimalFormat.format(sumofPrices));
        Assert.assertTrue(BrowserUtils.getText(totalPrice).contains(decimalFormat.format(sumofPrices)));


    }

}
