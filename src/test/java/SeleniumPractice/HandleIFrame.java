package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrame {
    
    @Test
    public void handleiFrame() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

        //1st frame 
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        //2nd frame
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[text()='Credentials']")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        //3rd frame
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("(//a[text()='Index'])[1]")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
