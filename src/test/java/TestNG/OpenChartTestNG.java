package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNG {
    @Test
    public void successfullylogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();

        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expected = "Dashboard";
        Assert.assertTrue(actualTitle.equals(expected));

    }

    @Test
    public void negaviteTesting() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("hello");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("bye");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(3000);
        WebElement messsage = driver.findElement(By.xpath("//div[@id ='alert']"));
        String Actual = messsage.getText().trim();
        String expected = "No match for Username and/or Password.";
        Assert.assertEquals(Actual, expected);
    }
    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@data-bs-dismiss = 'modal']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(products.isDisplayed());
    }

    @Test
    public void validateBoxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@data-bs-dismiss = 'modal']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();

        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        for (int i =1; i< allCheckboxes.size(); i++){
            Assert.assertTrue(allCheckboxes.get(i).isDisplayed());
            Assert.assertTrue(allCheckboxes.get(i).isEnabled());
            allCheckboxes.get(i).click();
            allCheckboxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            Assert.assertTrue(allCheckboxes.get(i).isSelected());
        }

    }
    @Test
    public void descendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@data-bs-dismiss = 'modal']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();

        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(2000);
        List<WebElement>  productNames = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames =new ArrayList<>();

        for (int i = 1; i<productNames.size();i++){
            actualNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedNames);
        Collections.reverse(expectedNames);
        System.out.println(expectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames,expectedNames);

    }

    @Test
    public  void validateProductNameFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@data-bs-dismiss = 'modal']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();
Thread.sleep(2000);
        List<WebElement>  productNames = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames =new ArrayList<>();
        for (int i = 1; i<productNames.size(); i++){
            actualNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
Collections.sort(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);


    }
}
