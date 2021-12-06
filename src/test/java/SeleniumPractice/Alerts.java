package SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
    
    @Test
    public void testAlerts() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert window with OK button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //Alert button with Ok/Cancel button
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        //Alert button with Prompt button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        Alert alertText = driver.switchTo().alert();
        System.out.println(alertText.getText());
        alertText.sendKeys("Hello Kshitij");
        driver.switchTo().alert().accept();
        
        Thread.sleep(3000);
        driver.quit();
    }
}
