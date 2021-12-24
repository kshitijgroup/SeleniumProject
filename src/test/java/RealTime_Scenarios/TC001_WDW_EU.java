package RealTime_Scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_WDW_EU {

    @Test
    public void waltDisneyScenario() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{
        driver.get("https://www.disneyworld.eu/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        
        WebElement hide = driver.findElement(By.xpath("//a[text()='Hide']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", hide);
        

        driver.findElement(By.xpath("//span[contains(text(),'')]")).click();

        driver.findElement(By.xpath("//a[@aria-label='Hotel']")).click();
        
        driver.findElement(By.xpath("//input[@id='checkInDate_display']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(@aria-label,'January 7')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(@aria-label,'January 9')]")).click();

        driver.findElement(By.xpath("//div[@class='party-selection party-selection-child']//button[contains(@aria-label,'Child Count Increment')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='party-selection child-age-container ng-scope']//descendant::span[@aria-label='Icon']")).click();

        driver.findElement(By.xpath("//a[@aria-label='4']")).click();

        driver.findElement(By.xpath("//button[@id='findPricesButton']")).click();

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        
        driver.findElement(By.xpath("//h2[(text()=\"Disney's Grand Floridian Resort & Spa\")]")).click();

        driver.findElement(By.xpath("//h2[(text()=\"Disney's Grand Floridian Resort & Spa\")]//parent::div//following-sibling::div[@class='price vertical right']//a")).click();
        } catch(Exception e){
            e.printStackTrace();
        }
        finally{
            Thread.sleep(3000);
            driver.quit();
        }

    }
}
