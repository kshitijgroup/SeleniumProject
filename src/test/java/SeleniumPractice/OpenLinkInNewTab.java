package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {
    
    @Test
    public void openLinkNewTab() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //Open Link in new tab
        String next = Keys.chord(Keys.CONTROL,Keys.ENTER);
        driver.findElement(By.linkText("Register")).sendKeys(next);
        
        //Open Second URL in new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.tutorialspoint.com/");

        //Open Second URL in new Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://jsonformatter.curiousconcept.com/#");
        
        Thread.sleep(3000);
        driver.quit();
    }
}
