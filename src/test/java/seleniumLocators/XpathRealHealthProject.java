package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.*/
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeappointment = driver.findElement(By.xpath("//a[@id= 'btn-make-appointment']"));
        makeappointment.click();

        WebElement username = driver.findElement(By.xpath("//input[@name ='username' ]"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@name ='password' ]"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.xpath("//button[@type = 'submit']"));
        login.click();

        WebElement facility = driver.findElement(By.xpath("//option[@value = 'Hongkong CURA Healthcare Center']"));
        facility.click();

        WebElement applyBox = driver.findElement(By.xpath("//input[@type ='checkbox']"));
        if (applyBox.isDisplayed() && !applyBox.isSelected()) {
            applyBox.click();
        }

        WebElement medicaid = driver.findElement(By.xpath("//input[@value = 'Medicaid']"));
        medicaid.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@name ='visit_date']"));
        visitDate.sendKeys("21/02/2023");

        WebElement command = driver.findElement(By.xpath("//textarea[@name ='comment']"));
        command.sendKeys("Hey, this is my comment - command)");

        WebElement bookappointment = driver.findElement(By.xpath("//button[@type = 'submit']"));
        bookappointment.click();

        //other parts

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(), 'Appointment Confirmation')]"));
        System.out.println(header.getText().trim().equals("Appointment Confirmation") ? "PASSED" : "FAILED");
        System.out.println(header.getText().trim());

        WebElement header1value = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println("the value 1: " + header1value.getText().trim());

        WebElement goHome = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        goHome.click();

        System.out.println(driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/") ? "PASSED" : "FAILED");

        driver.close();


    }
}
