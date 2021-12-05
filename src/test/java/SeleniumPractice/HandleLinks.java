package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {
    
    @Test
    public void handleLinks(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();

        //driver.findElement(By.linkText("Today's Deals")).click();
        driver.findElement(By.partialLinkText(" Deals")).click();

        //How to capture all the links from the webpage
        List<WebElement> li = driver.findElements(By.tagName("a"));
        System.out.println("Total links size: " +li.size());

        //Normal for loop
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i).getText());
            System.out.println(li.get(i).getAttribute("href"));
            System.out.println("*******************************");
        }

        driver.quit();
    }
}
