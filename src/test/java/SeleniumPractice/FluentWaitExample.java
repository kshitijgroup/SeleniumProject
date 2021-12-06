package SeleniumPractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {
    
    @Test
    public void explicitWait() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));

        ele.sendKeys("Selenium");
        ele.sendKeys(Keys.RETURN);

        //Usage of Fluent Wait
        By loc = By.xpath("//a[@href='https://www.selenium.dev/']");
        WebElement link = waitforElementWithFluentWait(driver, loc);

        link.click();

        Thread.sleep(3000);
        driver.quit();
    }

    public static WebElement waitforElementWithFluentWait(WebDriver driver, final By locator){
        
        //Declaration of Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(20))
            .ignoring(NoSuchElementException.class);

        //Usage of Fluent wait
        WebElement element = wait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(locator);
            }
        });
        return element;
    }
}
