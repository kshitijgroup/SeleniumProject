package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitExample {
    
    @Test
    public void implicitWait() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));

        ele.sendKeys("Selenium");
        ele.sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']")).click();

        Thread.sleep(3000);
        driver.quit();
    }

}
