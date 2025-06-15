package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ChromeFirefoxSearchTest {
    WebDriver driver;

    public void searchInBrowser(WebDriver driver, String browserName) {
        try {
            System.out.println("Running test on: " + browserName);
            driver.get("https://www.google.com");

            // Accept Google's consent popup if it appears
            try {
                WebElement acceptBtn = driver.findElement(By.xpath("//div[contains(text(),'Accept all')]"));
                acceptBtn.click();
            } catch (Exception ignored) {}

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("YouTube");
            searchBox.submit();

            Thread.sleep(3000); // Let results load
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testChrome() {
        driver = new ChromeDriver();
        searchInBrowser(driver, "Chrome");
    }

    @Test
    public void testFirefox() {
        driver = new FirefoxDriver();
        searchInBrowser(driver, "Firefox");
    }
}
