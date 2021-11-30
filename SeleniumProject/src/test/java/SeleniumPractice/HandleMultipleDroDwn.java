package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * HandleMultipleDroDwn
 */
public class HandleMultipleDroDwn {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Hello World");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.amazon.com");
        Thread.sleep(2000);

        driver.quit();
    }
}