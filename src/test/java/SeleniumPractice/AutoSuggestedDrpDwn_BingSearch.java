package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestedDrpDwn_BingSearch {
    
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.bing.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");

        List<WebElement> li = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
        System.out.println(li.size());

        for(WebElement option : li){
            if(option.getText().equalsIgnoreCase("selenium testing")){
                option.click();
                break;
            }
        }
        driver.quit();
    }
}
