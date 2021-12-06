package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {
    
    @Test
    public void implicitWait() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));

        ele.sendKeys("Selenium");
        ele.sendKeys(Keys.RETURN);

        By loc = By.xpath("//a[@href='https://www.selenium.dev/']");
        WebElement selenium = webdriverExplicitWait(driver, loc, 10);
        selenium.click();

        Thread.sleep(3000);
        driver.quit();
    }

    public static WebElement webdriverExplicitWait(WebDriver driver, By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);

    }

}
