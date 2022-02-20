package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaceDrpDwn {
    
    @Test
    public void autoComplete() throws Exception {
        
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.twoplugs.com/");

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");

        String text;

        do{
            searchBox.sendKeys(Keys.ARROW_DOWN);
            text = searchBox.getAttribute("value");
            System.out.println(text);
            if(text.equals("Toronto, OH, USA")){
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(3000);
        }while(!text.isEmpty());
        Thread.sleep(3000);
        driver.quit(); 
    }
}
