package seleniumPrograms;

import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SeleniumTest extends BaseTest{
    @Test
    public void BrokenLinks(){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            try {
                URL urls =new URL(url);
                HttpURLConnection connection = (HttpURLConnection) (urls.openConnection());
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
            } catch (Exception e) {
                System.out.println(url + " is a broken link");
            }
        }
        driver.quit();
    }

}
