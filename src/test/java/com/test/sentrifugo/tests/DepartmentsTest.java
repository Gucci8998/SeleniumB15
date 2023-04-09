package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.DepartmentsPage;
import com.test.sentrifugo.pages.HomePage;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DepartmentsTest {
    @Test
    public void validateMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        homePage.clickDepartment();
        Thread.sleep(2000);
        DepartmentsPage departmentsPage = new DepartmentsPage(driver);
        departmentsPage.validateDepartmentFunctionality("IT","312","Department added successfully.");

        departmentsPage.validateTableInfofromList("Information Technology","IT","01/05/2001","Thomas E","America/New_York [EDT]","Orange Blossom");

    }
}
