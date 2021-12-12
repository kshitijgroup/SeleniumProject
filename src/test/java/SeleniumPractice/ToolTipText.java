package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipText {
    
    @Test
    public void captureToolTip(){
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://testautomationpractice.blogspot.com/?");

        WebElement tip1 = driver.findElement(By.xpath("//a[normalize-space()='Tooltips']"));
        WebElement tip2 = driver.findElement(By.xpath("//input[@id='age']"));

        String text1 = tip1.getAttribute("title");
        String text2 = tip2.getAttribute("title");

        System.out.println(text1);
        System.out.println(text2);

        driver.quit();
    }
}
