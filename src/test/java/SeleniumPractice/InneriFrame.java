package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InneriFrame {
    
    @Test
    public void inneriFrame() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

        //Switch to Outer Frame
        WebElement parentFrame = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(parentFrame);

        //Switch to Inner Frame
        WebElement childFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(childFrame);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello Kshitij");
    }

}
