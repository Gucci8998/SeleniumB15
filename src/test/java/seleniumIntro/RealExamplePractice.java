package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.out.println("my browser is Chrome");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        String actualTitle = driver.getTitle();
        String expectedtitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.godaddy.com/";
        if(actualTitle.equals(expectedtitle)){
            System.out.println("title is passed");
        }else {
            System.out.println("title is failed");
        }

        if(actualURL.equals(expectedURL)){
            System.out.println("passed");
        }else {
            System.out.println("FAILED");
        }
        driver.quit();
    }
}
