package seleniumIntro.homework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homework1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ulta.com/?cmpid=PS_Brand!google!Brand&utm_source=google&utm_medium=paidsearch&CAWELAID=1831598544&CATRK=SPFID-1&CAAGID=540267060&CATCI=kwd-12627301&CAPCID=627790632873&CADevice=c&gclid=CjwKCAiAuaKfBhBtEiwAht6H72ogk5BsbqLToL0onaPgVK5NlWSiOR1o-GA8axtvcftciXBPuS4PORoCCKwQAvD_BwE");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Ulta Beauty | Official Site - Makeup, Hair Care, Skin Care, Fragrance, Bath &amp; Gifts";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("your test is passed");
        } else {
            System.out.println("your test is failed");
        }
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.gucci.com/us/en/");
        System.out.println(driver1.getTitle());
        String actualTitle2 = driver1.getTitle();
        String expectedTitle2 = "GUCCI® US Official Site | Redefining Luxury Fashion";
        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println("your test is passed");
        } else {
            System.out.println("your test is failed");
        }
        driver.close();

        driver1.quit();
    }
}