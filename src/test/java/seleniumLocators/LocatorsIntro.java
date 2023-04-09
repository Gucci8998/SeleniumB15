package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    //ID LOCATOR
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/gucci/Downloads/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();
        String expectedHeader= "Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)? "passed" : "failed");
WebElement actualtext = driver.findElement(By.id("details2"));
        System.out.println(actualtext.getText().trim());

    // NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Gulmira");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ibraeva");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("555555555");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("dolp@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("Michigan Ave");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postal = driver.findElement(By.name("postalCode"));
        postal.sendKeys("60016");
        Thread.sleep(3000);
        //ID IS MORE RELIABLE

        //CLASS LOCATOR:

        WebElement checkboxLabel = driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxLabel.getText());

        WebElement checkbox1 = driver.findElement(By.id("cond1"));
        if(checkbox1.isDisplayed()&& !checkbox1.isSelected()){
            checkbox1.click();
        }
        WebElement checkbox2 = driver.findElement(By.id("cond2"));
        if(checkbox2.isDisplayed()&& !checkbox2.isSelected()){
            checkbox2.click();
        }
        System.out.println(checkbox2.isSelected());
        WebElement checkbox3 = driver.findElement(By.id("cond3"));
        if(checkbox3.isDisplayed()&& !checkbox3.isSelected()){
            checkbox3.click();
        }
        WebElement checkbox4 = driver.findElement(By.id("cond4"));
        if(checkbox4.isDisplayed()&& !checkbox4.isSelected()){
            checkbox4.click();
        }

        //TAG NAME LOCATOR:

        WebElement version = driver.findElement(By.tagName("u"));
     String actualVersion = version.getText().trim();
     String expectedVersion = "Use Java Version";
     if(actualVersion.equals(expectedVersion)){
         System.out.println("passsed");
     } else{
         System.out.println("FAILED");
     }



    }
}
